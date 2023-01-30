package com.example.uzcardservice.config;

import com.example.uzcardservice.entity.Card;
import com.example.uzcardservice.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final CardRepository cardRepository;

    @Value(value = "${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) {
        if (ddl.equals("create-drop") || ddl.equals("create")) {
            saveCards();
        }
    }


    private void saveCards() {
        BigInteger pan = BigInteger.valueOf(4585474563215987L);
        int pinCode = 1111;
        for (int i = 1; i <= 1000; i++) {
            cardRepository.save(new Card(
                    "" + pan,
                    new StringBuffer("" + pan).replace(5, 9, "****").toString(),
                    "" + (pinCode++),
                    100000L,
                    makeCardExp(i)

            ));
            pan = pan.add(BigInteger.ONE);
        }
    }

    private String makeCardExp(int num) {
        LocalDate localDate = LocalDate.now();
        LocalDate days = localDate.plusYears(5).plusDays(num);
        String date = days.getYear() + "";
        String month = days.getMonthValue() + "";
        return (date.length() == 2 ? date : date.substring(date.length() - 2)) + (month.length() == 1 ? "0" + month : month);
    }
}
