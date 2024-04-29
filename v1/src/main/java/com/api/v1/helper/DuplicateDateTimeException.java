package com.api.v1.helper;

public class DuplicateDateTimeException extends RuntimeException {

    public DuplicateDateTimeException() {
        super("The date times cannot be equal.");
    }
    
}
