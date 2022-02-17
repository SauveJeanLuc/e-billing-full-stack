package com.electricity.seller.controllers;

import com.electricity.seller.dtos.BuyElectricityDTO;
import com.electricity.seller.exceptions.CustomException;
import com.electricity.seller.services.TokenService;
import com.electricity.seller.utils.APICustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tokens")
public class TokenController {

    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService){
        this.tokenService =  tokenService;
    }

    @PostMapping("/buy")
    public ResponseEntity<APICustomResponse> buyElectricity(@RequestBody BuyElectricityDTO dto) throws CustomException {
        return ResponseEntity.status(HttpStatus.OK).body(new APICustomResponse(true, "Electricity generated successfully", tokenService.generateToken(dto) ));
    }

}
