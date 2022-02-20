package com.electricity.seller.services;

import com.electricity.seller.dtos.BuyElectricityDTO;
import com.electricity.seller.dtos.LoadElectricityDTO;
import com.electricity.seller.enums.ETokenStatus;
import com.electricity.seller.exceptions.CustomException;
import com.electricity.seller.models.Meter;
import com.electricity.seller.models.Token;
import com.electricity.seller.repositories.IMeterRepository;
import com.electricity.seller.repositories.ITokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TokenService {

    private final ITokenRepository tokenRepository;
    private final IMeterRepository meterRepository;

    @Autowired
    public TokenService(ITokenRepository tokenRepository, IMeterRepository meterRepository){
        this.tokenRepository = tokenRepository;
        this.meterRepository = meterRepository;
    }

    public Token generateToken(BuyElectricityDTO dto) throws CustomException {
        //Validate Meter Number (Size)
        if(String.valueOf(dto.getMeterNumber()).length() != 6){
            throw new CustomException("Invalid meter, only 6 digits accepted", HttpStatus.BAD_REQUEST);
        }

        //Validate Meter Number (Exists)
        Optional<Meter> foundMeter = meterRepository.findByMeterNumber(dto.getMeterNumber());
        if(!foundMeter.isPresent()){
            throw new CustomException("Unknown Meter Number", HttpStatus.BAD_REQUEST);
        }

        // Check if amount of money meets constraints
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

    public Integer loadElectricity(LoadElectricityDTO dto) throws CustomException{
        /* ***** Start Token Validation ****** */

        //Validate Token (Size)
        if(String.valueOf(dto.getToken()).length() != 8){
            throw new CustomException("Invalid token, only 8 digits accepted", HttpStatus.BAD_REQUEST);
        }

        //Validate Token (Exists)
        Optional<Token> foundToken = tokenRepository.findByValue(dto.getToken());
        if(!foundToken.isPresent()){
            throw new CustomException("Unknown Token", HttpStatus.BAD_REQUEST);
        }

        //Validate Token (Used)
        if(tokenRepository.existsByValueAndStatus(dto.getToken(), ETokenStatus.USED)){
            throw new CustomException("Token is already used", HttpStatus.BAD_REQUEST);
        }

        //Validate Token (Used)
        if(tokenRepository.existsByValueAndStatus(dto.getToken(), ETokenStatus.USED)){
            throw new CustomException("Token is already used", HttpStatus.BAD_REQUEST);
        }
        /* ***** End Token Validation ****** */

        /* ***** Start Meter Number Validation ****** */

        //Validate Meter Number (Size)
        if(String.valueOf(dto.getMeterNumber()).length() != 6){
            throw new CustomException("Invalid meter, only 6 digits accepted", HttpStatus.BAD_REQUEST);
        }

        //Validate Meter Number (Exists)
        Optional<Meter> foundMeter = meterRepository.findByMeterNumber(dto.getMeterNumber());
        if(!foundMeter.isPresent()){
            throw new CustomException("Unknown Meter Number", HttpStatus.BAD_REQUEST);
        }

        /* ***** End Meter Number Validation ****** */

        //Update Number of Days
        foundMeter.get().setRemainingDays(foundMeter.get().getRemainingDays() + foundToken.get().getDuration());

        //Change Token Status
        foundToken.get().setStatus(ETokenStatus.USED);

        //Update Meter
        meterRepository.save(foundMeter.get());

        //Update Token
        tokenRepository.save(foundToken.get());

        //Return Duration
        return foundToken.get().getDuration();

    }

    public List<Token> getAll(){
        return tokenRepository.findAll();
    }

}
