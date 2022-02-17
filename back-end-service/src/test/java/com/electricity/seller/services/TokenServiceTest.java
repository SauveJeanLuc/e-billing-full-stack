package com.electricity.seller.services;

import com.electricity.seller.dtos.BuyElectricityDTO;
import com.electricity.seller.exceptions.CustomException;
import com.electricity.seller.models.Token;
import com.electricity.seller.repositories.IMeterRepository;
import com.electricity.seller.repositories.ITokenRepository;
import org.mockito.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

public class TokenServiceTest {
    @Mock
    private ITokenRepository tokenRepository;

    @Mock
    private IMeterRepository meterRepository;

    @Captor
    private ArgumentCaptor<Token> tokenArgumentCaptor;

    @InjectMocks
    private TokenService underTest;

//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        underTest = new TokenService(tokenRepository,meterRepository);
//    }

    @Test
    public void itShouldGenerateTokenSuccessfully() throws CustomException {
        Integer amountOfMoney = 2000;
        Integer meterNumber = 12345678;

        BuyElectricityDTO dto = new BuyElectricityDTO(amountOfMoney,meterNumber);
        Token generatedToken = underTest.generateToken(dto);

        then(tokenRepository).should().save(tokenArgumentCaptor.capture());
        Token tokenArgumentCaptorValue = tokenArgumentCaptor.getValue();
        assertThat(tokenArgumentCaptorValue).isEqualTo(generatedToken);
    }

    @Test
    public void itShouldNotSaveWhenMeterNumberIsInvalid(){

    }

    @Test
    public void itShouldNotSaveWhenAmountOfMoneyIsInvalid(){

    }
}
