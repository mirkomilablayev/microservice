package com.example.uzcardservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateDTO {
    private String pan;
    private String maskedPan;
    private String pinCode;
    private Long cardBalance;
    private String expDate;
}
