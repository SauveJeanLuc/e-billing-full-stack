package com.electricity.seller.repositories;

import com.electricity.seller.models.Meter;
import com.electricity.seller.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMeterRepository extends JpaRepository<Meter, Long> {

}
