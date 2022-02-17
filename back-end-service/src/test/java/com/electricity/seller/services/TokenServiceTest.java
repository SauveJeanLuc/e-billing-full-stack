package com.electricity.seller.services;

import com.electricity.seller.repositories.IMeterRepository;
import com.electricity.seller.repositories.ITokenRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TokenServiceTest {
    @Mock
    private ITokenRepository tokenRepository;

    @Mock
    private IMeterRepository meterRepository;

    private TokenService underTest;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        underTest = new TokenService(tokenRepository,meterRepository);
    }

    @Test
    void itShouldGenerateTokenSuccessfully(){

    }

    @Test
    void itShouldNotSaveWhenMeterNumberIsInvalid(){

    }

    @Test
    void itShouldNotSaveWhenAmountOfMoneyIsInvalid(){

    }
}
