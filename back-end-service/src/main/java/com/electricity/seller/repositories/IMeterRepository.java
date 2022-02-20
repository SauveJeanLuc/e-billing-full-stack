package com.electricity.seller.repositories;

import com.electricity.seller.models.Meter;
import com.electricity.seller.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMeterRepository extends JpaRepository<Meter, Long> {
    Optional<Meter> findByMeterNumber(Integer meterNumber);
}
