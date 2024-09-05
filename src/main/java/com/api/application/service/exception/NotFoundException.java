package com.api.application.service.exception;

import java.io.Serializable;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Resource not found.");
    }

}
