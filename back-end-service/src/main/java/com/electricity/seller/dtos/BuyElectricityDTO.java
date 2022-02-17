package com.electricity.seller.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyElectricityDTO {

    private Integer amountOfMoney;

    private Integer meterNumber;

}
