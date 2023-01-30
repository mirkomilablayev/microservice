package com.example.uzcardservice.service;

import com.example.uzcardservice.dto.CommonResultData;
import com.example.uzcardservice.dto.request.CardCreateDTO;
import com.example.uzcardservice.dto.request.GetCardRequestDTO;
import com.example.uzcardservice.dto.request.TransactionRequestDTO;

public interface CardService {
    CommonResultData<?> createCard(CardCreateDTO cardCreateDTO);
    CommonResultData<?> getCard(GetCardRequestDTO getCardRequestDTO);
    CommonResultData<?> transfer(TransactionRequestDTO transactionRequestDTO);
}
