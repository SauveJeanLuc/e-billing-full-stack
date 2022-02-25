package com.electricity.seller.repositories;

import com.electricity.seller.enums.ETokenStatus;
import com.electricity.seller.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Long> {
    boolean existsByValue(Integer value);
    Optional<Token> findByValue(Integer value);
    boolean existsByValueAndStatus(Integer value, ETokenStatus status);
}
