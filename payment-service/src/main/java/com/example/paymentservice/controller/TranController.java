package com.example.paymentservice.controller;


import com.example.paymentservice.service.TranService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tran")
public class TranController {
    private final TranService tranService;
}
