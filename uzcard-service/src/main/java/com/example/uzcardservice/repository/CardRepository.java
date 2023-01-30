package com.example.uzcardservice.repository;


import com.example.uzcardservice.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
Optional<Card> findByPanAndExpDate(String pan, String expDate);
Optional<Card> findByPan(String pan);
Boolean existsByPan(String pan);

}
