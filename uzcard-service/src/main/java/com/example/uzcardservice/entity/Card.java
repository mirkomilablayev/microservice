package com.example.uzcardservice.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String pan;
    private String maskedPan;
    private String pinCode;
    private Long cardBalance;
    private String expDate;

    public Card(String pan, String maskedPan, String pinCode, Long cardBalance, String expDate) {
        this.pan = pan;
        this.maskedPan = maskedPan;
        this.pinCode = pinCode;
        this.cardBalance = cardBalance;
        this.expDate = expDate;
    }
}
