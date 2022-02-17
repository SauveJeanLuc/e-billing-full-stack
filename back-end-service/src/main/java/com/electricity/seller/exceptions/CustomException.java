package com.electricity.seller.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


public class CustomException extends Throwable {

    private HttpStatus httpStatus;
    private String message;

    public CustomException() {
    }

    public CustomException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}