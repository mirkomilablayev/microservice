package com.example.uzcardservice.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCardRequestDTO {
    private String pan;
    private String expDate;
}
