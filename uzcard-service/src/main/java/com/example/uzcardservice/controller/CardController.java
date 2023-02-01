package com.example.uzcardservice.controller;

import com.example.uzcardservice.dto.CommonResultData;
import com.example.uzcardservice.dto.request.GetCardRequestDTO;
import com.example.uzcardservice.dto.request.TransactionRequestDTO;
import com.example.uzcardservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/transfer")
    public CommonResultData<?> transfer(@RequestBody TransactionRequestDTO transactionRequestDTO){
        return cardService.transfer(transactionRequestDTO);
    }


    @PostMapping("/get-card")
    public CommonResultData<?> getCard(@RequestBody GetCardRequestDTO getCardRequestDTO){
        return cardService.getCard(getCardRequestDTO);
    }
}
