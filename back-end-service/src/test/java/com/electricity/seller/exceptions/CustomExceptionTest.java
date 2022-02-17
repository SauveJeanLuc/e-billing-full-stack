package com.electricity.seller.exceptions;

import com.electricity.seller.models.Token;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class CustomExceptionTest {

    @Test
    public void testCustomExceptionHasImportantProperties(){
        CustomException exception = new CustomException();
        assertThat(exception, hasProperty("httpStatus"));
        assertThat(exception, hasProperty("message"));
    }
}
