package com.electricity.seller.payload;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class LoadElectricityResponseTest {

    @Test
    public void testLoadElectricityResponseHasImportantProperties(){
        LoadElectricityResponse response = new LoadElectricityResponse();
        assertThat(response, hasProperty("daysAdded"));
        assertThat(response, hasProperty("daysRemaining"));
    }

}
