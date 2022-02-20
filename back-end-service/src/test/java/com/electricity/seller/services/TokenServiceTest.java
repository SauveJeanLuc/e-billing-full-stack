package com.electricity.seller.services;

import com.electricity.seller.dtos.BuyElectricityDTO;
import com.electricity.seller.dtos.LoadElectricityDTO;
import com.electricity.seller.enums.ETokenStatus;
import com.electricity.seller.exceptions.CustomException;
import com.electricity.seller.models.Meter;
import com.electricity.seller.models.Token;
import com.electricity.seller.repositories.IMeterRepository;
import com.electricity.seller.repositories.ITokenRepository;
import org.junit.Before;
import org.mockito.*;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


public class TokenServiceTest {

    @InjectMocks
    private TokenService underTest;

    @Mock
    private ITokenRepository tokenRepository;

    @Mock
    private IMeterRepository meterRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void itShouldGenerateTokenSuccessfully() throws CustomException {
        Integer amountOfMoney = 2000;
        Integer meterNumber = 123456;

        BuyElectricityDTO dto = new BuyElectricityDTO(amountOfMoney,meterNumber);

        Long id = 132l;
        Meter meter = new Meter(id, meterNumber, 0);
        Token token = new Token();
        token.setValue(12345678);
        token.setAmountPayed(2000);
        token.setDuration(20);
        token.setMeter(meter);
        token.setStatus(ETokenStatus.USED);

        when(tokenRepository.save(any(Token.class))).thenReturn(token);
        when(meterRepository.findByMeterNumber(any(Integer.class))).thenReturn(Optional.of(meter));
        assertEquals(20,underTest.generateToken(dto).getDuration());

    }



    @Test
    public void itShouldNotSaveWhenMeterNumberIsInvalid(){

    }

    @Test
    public void itShouldNotSaveWhenAmountOfMoneyIsInvalid(){

    }

    @Test
    public void itShouldLoadElectricitySuccessfully() throws CustomException {
        Integer tokenValue = 12345687;
        Integer meterNumber = 123456;
        LoadElectricityDTO dto = new LoadElectricityDTO(tokenValue, meterNumber);

        Long id = 132l;
        Meter meter = new Meter(id, meterNumber, 0);

        Token token = new Token();
        token.setValue(12345678);
        token.setAmountPayed(2000);
        token.setDuration(20);
        token.setMeter(meter);
        token.setStatus(ETokenStatus.ACTIVE);

        when(tokenRepository.findByValue(any(Integer.class))).thenReturn(Optional.of(token));
        when(tokenRepository.existsByValueAndStatus(any(Integer.class),any(ETokenStatus.class))).thenReturn(false);
        when(meterRepository.findByMeterNumber(any(Integer.class))).thenReturn(Optional.of(meter));
        token.setStatus(ETokenStatus.USED);
        when(tokenRepository.save(any(Token.class))).thenReturn(token);
        assertEquals(20,underTest.loadElectricity(dto));
    }
}
