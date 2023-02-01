package com.example.paymentservice.controller;


import com.example.paymentservice.dto.CommonResultData;
import com.example.paymentservice.dto.request.TranRequestDTO;
import com.example.paymentservice.service.TranService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tran")
public class TranController {
    private final TranService tranService;

    @PostMapping("/perform-tran")
    public CommonResultData<?> transfer(@RequestBody TranRequestDTO tranRequestDTO){
        return tranService.transfer(tranRequestDTO);
    }
}
