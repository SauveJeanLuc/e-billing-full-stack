package com.electricity.seller.services;

import com.electricity.seller.dtos.BuyElectricityDTO;
import com.electricity.seller.enums.ETokenStatus;
import com.electricity.seller.exceptions.CustomException;
import com.electricity.seller.models.Meter;
import com.electricity.seller.models.Token;
import com.electricity.seller.repositories.IMeterRepository;
import com.electricity.seller.repositories.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class TokenService {

    private final ITokenRepository tokenRepository;
    private final IMeterRepository meterRepository;

    @Autowired
    public TokenService(@Lazy ITokenRepository tokenRepository, @Lazy IMeterRepository meterRepository){
        this.tokenRepository = tokenRepository;
        this.meterRepository = meterRepository;
    }

    public Token generateToken(BuyElectricityDTO dto) throws CustomException {
        //Validate Meter Number (Size)
        if(String.valueOf(dto.getMeterNumber()).length() != 6){
            throw new CustomException("Invalid meter, only 6 digits accepted", HttpStatus.BAD_REQUEST);
        }

        //Validate Meter Number (Does not Exist)
        Optional<Meter> foundMeter = meterRepository.findByMeterNumber(dto.getMeterNumber());
        if(foundMeter.isEmpty()){
            throw new CustomException("Meter number is not found", HttpStatus.BAD_REQUEST);
        }

        if((dto.getAmountOfMoney() % 100 != 0) || (dto.getAmountOfMoney() < 100) || (dto.getAmountOfMoney() > 182500 )){
            throw new CustomException("invalid amount, only\n" +
                    "multiples of 100 not greater than 182,500 is accepted", HttpStatus.BAD_REQUEST);
        }

        //Generate random Token
        //Re-Generate if it already exists

        Random random = new Random();
        Integer randomToken;
        do {
            randomToken = random.nextInt(99999999 - 10000000) + 10000000;
        } while (tokenRepository.existsByValue(randomToken));

        //Generate Duration

        Integer duration = dto.getAmountOfMoney() / 100;

        //Create Token Instance

        Token generatedToken = new Token();
        generatedToken.setValue(randomToken);
        generatedToken.setAmountPayed(dto.getAmountOfMoney());
        generatedToken.setDuration(duration);
        generatedToken.setMeter(foundMeter.get());
        generatedToken.setStatus(ETokenStatus.USED);

        //Save Token

        return tokenRepository.save(generatedToken);

    }

}
