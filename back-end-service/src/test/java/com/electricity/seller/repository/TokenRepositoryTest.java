package com.electricity.seller.repository;


import com.electricity.seller.enums.ETokenStatus;
import com.electricity.seller.models.Meter;
import com.electricity.seller.models.Token;
import com.electricity.seller.repositories.IMeterRepository;
import com.electricity.seller.repositories.ITokenRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(
        properties = {
                "spring.jpa.properties.javax.persistence.validation.mode=none"
        }
)
public class TokenRepositoryTest {

    @Autowired
    private ITokenRepository underTest;

    @Test
    void itShouldSaveToken() {
        // Given
        Long id = 132l;
        Meter meter = new Meter(id, 123456, 0);
        Token token = new Token();
        token.setValue(12345678);
        token.setAmountPayed(200);
        token.setDuration(3);
        token.setMeter(meter);
        token.setStatus(ETokenStatus.USED);

        // When
        Token savedToken = underTest.save(token);
        assertThat(token.getValue()).isEqualTo(savedToken.getValue());

    }

}
