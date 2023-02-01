package com.example.uzcardservice.service.impl;

import com.example.uzcardservice.dto.CommonResponse;
import com.example.uzcardservice.dto.CommonResultData;
import com.example.uzcardservice.dto.request.CardCreateDTO;
import com.example.uzcardservice.dto.request.GetCardRequestDTO;
import com.example.uzcardservice.dto.request.TransactionRequestDTO;
import com.example.uzcardservice.entity.Card;
import com.example.uzcardservice.entity.Transaction;
import com.example.uzcardservice.repository.CardRepository;
import com.example.uzcardservice.repository.TransactionRepository;
import com.example.uzcardservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public CommonResultData<?> createCard(CardCreateDTO cardCreateDTO) {
        return null;
    }

    @Override
    public CommonResultData<?> getCard(GetCardRequestDTO getCardRequestDTO) {
        Optional<Card> cardOptional = cardRepository.findByPanAndExpDate(getCardRequestDTO.getPan(), getCardRequestDTO.getExpDate());
        if (getCardRequestDTO.getPan() == null || cardOptional.isEmpty()) {
            return new CommonResultData<>(CommonResponse.CARD_NOT_FOUND.getCode(), CommonResponse.CARD_NOT_FOUND.getMsg());
        }
        return new CommonResultData<>(cardOptional.get(), CommonResponse.SUCCESS.getCode(), CommonResponse.SUCCESS.getMsg());
    }


    @Override
    public CommonResultData<?> transfer(TransactionRequestDTO transactionRequestDTO) {
        Optional<Card> receiverCardOpt = cardRepository.findByPan(transactionRequestDTO.getReceiverPan());
        Optional<Card> senderCardOpt = cardRepository.findByPan(transactionRequestDTO.getSenderPan());
        if (senderCardOpt.isPresent() && receiverCardOpt.isPresent()) {
            Card senderCard = senderCardOpt.get();
            Card receiverCard = receiverCardOpt.get();
            if (senderCard.getCardBalance() < 0 ||
                    senderCard.getCardBalance() < transactionRequestDTO.getAmount()) {
                return new CommonResultData<>(CommonResponse.CARD_AMOUNT_INCORRECT.getCode(), CommonResponse.CARD_AMOUNT_INCORRECT.getMsg());
            }
            senderCard.setCardBalance(senderCard.getCardBalance() - transactionRequestDTO.getAmount());
            receiverCard.setCardBalance(receiverCard.getCardBalance() + transactionRequestDTO.getAmount());
            cardRepository.save(senderCard);
            cardRepository.save(receiverCard);
            Transaction transaction = Transaction.builder()
                    .senderMaskedPan(senderCard.getMaskedPan())
                    .receiverMaskedPan(receiverCard.getMaskedPan())
                    .amount(transactionRequestDTO.getAmount())
                    .transactionTime(LocalDateTime.now())
                    .build();
            Transaction savedTransaction = transactionRepository.save(transaction);
            return new CommonResultData<>(savedTransaction, CommonResponse.SUCCESS.getCode(), CommonResponse.SUCCESS.getMsg());
        }
        return new CommonResultData<>(CommonResponse.CARD_NOT_FOUND.getCode(), CommonResponse.CARD_NOT_FOUND.getMsg());
    }
}
