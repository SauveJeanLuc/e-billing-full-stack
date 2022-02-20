package com.electricity.seller.dtos;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class LoadElectricityDTOTest {

    @Test
    public void testLoadElectricityDTOHasImportantProperties(){
        LoadElectricityDTO dto = new LoadElectricityDTO();
        assertThat(dto, hasProperty("token"));
        assertThat(dto, hasProperty("meterNumber"));
    }

}
