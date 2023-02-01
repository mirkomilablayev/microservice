package com.example.paymentservice.service;

import com.example.paymentservice.dto.CommonResponse;
import com.example.paymentservice.dto.CommonResultData;
import com.example.paymentservice.dto.request.TranRequestDTO;
import com.example.paymentservice.dto.response.TransactionDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TranService {
    private static final String UZCARD_SERVICE_TRANSFER_URL = "http://UZCARD-SERVICE/api/card/transfer";
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public CommonResultData<?> transfer(TranRequestDTO tranRequestDTO) {
        CommonResultData commonResultData = restTemplate.postForObject(UZCARD_SERVICE_TRANSFER_URL, tranRequestDTO, CommonResultData.class);
        if (commonResultData != null && commonResultData.getCode() == CommonResponse.SUCCESS.getCode()) {
            return new CommonResultData<>(mapper.convertValue(commonResultData.getData(),TransactionDto.class));
        }
        assert commonResultData != null;
        return new CommonResultData<>(commonResultData.getCode(), commonResultData.getMsg());
    }
}
