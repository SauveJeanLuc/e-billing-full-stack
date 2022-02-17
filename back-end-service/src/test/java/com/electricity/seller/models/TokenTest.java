package com.electricity.seller.models;

import com.electricity.seller.enums.ETokenStatus;
import org.junit.Test;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class TokenTest {

    @Test
    public void testTokenHasImportantProperties(){
        Token token = new Token();
        assertThat(token, hasProperty("id"));
        assertThat(token, hasProperty("value"));
        assertThat(token, hasProperty("duration"));
        assertThat(token, hasProperty("amountPayed"));
        assertThat(token, hasProperty("status"));
        assertThat(token, hasProperty("meter"));
    }

}
