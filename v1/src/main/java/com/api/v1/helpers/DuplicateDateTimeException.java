package com.api.v1.helpers;

public class DuplicateDateTimeException extends RuntimeException {

    public DuplicateDateTimeException() {
        super("The date times cannot be equal.");
    }
    
}
