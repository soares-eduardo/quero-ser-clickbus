package com.eduardosoares.QueroSerClickbusBackend.business_rules.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
