package com.example.uzcardservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {
    private String senderPan;
    private String receiverPan;
    private Long amount;
}
