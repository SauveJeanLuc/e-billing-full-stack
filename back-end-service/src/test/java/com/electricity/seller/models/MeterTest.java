package com.electricity.seller.models;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class MeterTest {

    @Test
    public void testMeterHasImportantProperties(){
        Meter meter = new Meter();
        assertThat(meter, hasProperty("id"));
        assertThat(meter, hasProperty("meterNumber"));
        assertThat(meter, hasProperty("remainingDays"));
    }

}
