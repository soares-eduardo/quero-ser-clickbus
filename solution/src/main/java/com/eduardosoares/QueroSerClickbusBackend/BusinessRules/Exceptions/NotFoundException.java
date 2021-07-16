package com.eduardosoares.QueroSerClickbusBackend.BusinessRules.Exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
        super("City not found.");
    }
}
