package com.electricity.seller.repositories;

import com.electricity.seller.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Long> {
    boolean existsByValue(Integer value);
}
