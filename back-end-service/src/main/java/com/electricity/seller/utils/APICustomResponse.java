package com.electricity.seller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class APICustomResponse {

    private boolean status;

    private String message;

    private Object data;


}
