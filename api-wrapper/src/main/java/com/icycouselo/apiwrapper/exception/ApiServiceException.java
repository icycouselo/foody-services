package com.icycouselo.apiwrapper.exception;

import lombok.Getter;

public class ApiServiceException extends RuntimeException{
    @Getter
    private int statusCode;

    public ApiServiceException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
