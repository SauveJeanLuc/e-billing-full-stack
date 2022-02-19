package com.electricity.seller.repository;


import com.electricity.seller.models.Meter;
import com.electricity.seller.repositories.IMeterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(
        properties = {
                "spring.jpa.properties.javax.persistence.validation.mode=none"
        }
)
public class MeterRepositoryTest {

    @Autowired
    private IMeterRepository underTest;

    @Test
    void itShouldSaveMeter() {
        // Given
        Long id = 132l;
        Meter meter = new Meter(id, 123456);

        // When
         Meter savedMeter = underTest.save(meter);
         assertThat(savedMeter.getMeterNumber()).isEqualTo(meter.getMeterNumber());

    }

}
