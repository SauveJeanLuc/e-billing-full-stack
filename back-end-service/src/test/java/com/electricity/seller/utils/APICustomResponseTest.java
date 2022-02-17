package com.electricity.seller.utils;

import org.junit.Test;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class APICustomResponseTest {

    @Test
    public void testAPICustomResponseHasImportantProperties(){
        APICustomResponse response= new APICustomResponse();
        assertThat(response, hasProperty("status"));
        assertThat(response, hasProperty("message"));
        assertThat(response, hasProperty("data"));
    }

}
