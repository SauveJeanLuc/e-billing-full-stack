package com.electricity.seller.dtos;

import org.apache.commons.collections4.Get;
import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class GetRemainingDaysDTOTest {

    @Test
    public void testGetRemainingDaysDTOHasImportantProperties(){
        GetRemainingDaysDTO dto = new GetRemainingDaysDTO();
        assertThat(dto, hasProperty("meterNumber"));
    }

}
