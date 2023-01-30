package com.example.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TranService {
    private static final String UZCARD_SERVICE_TRANSFER_URL = "localhost:7778/api/card/transfer";
    private final RestTemplate restTemplate;

}
