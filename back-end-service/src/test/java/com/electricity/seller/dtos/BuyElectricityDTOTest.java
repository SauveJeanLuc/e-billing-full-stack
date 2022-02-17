package com.electricity.seller.dtos;

import com.electricity.seller.models.Token;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class BuyElectricityDTOTest {

    @Test
    public void testBuyElectricityDTOHasImportantProperties(){
        BuyElectricityDTO dto = new BuyElectricityDTO();
        assertThat(dto, hasProperty("amountOfMoney"));
        assertThat(dto, hasProperty("meterNumber"));
    }
    
}
