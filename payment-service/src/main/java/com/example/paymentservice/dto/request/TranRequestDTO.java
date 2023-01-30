package com.example.paymentservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranRequestDTO {
    private String senderPan;
    private String receiverPan;
    private Long amount;
}
