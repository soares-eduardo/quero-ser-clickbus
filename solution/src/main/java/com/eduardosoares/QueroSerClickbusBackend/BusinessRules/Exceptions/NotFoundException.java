package com.eduardosoares.QueroSerClickbusBackend.BusinessRules.Exceptions;

import com.eduardosoares.QueroSerClickbusBackend.Utils.MessageUtils;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
