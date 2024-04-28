package com.api.v1.helper.exceptions;

public class DuplicateDateTimeException extends RuntimeException {

    public DuplicateDateTimeException() {
        super("The date times cannot be equal.");
    }
    
}
