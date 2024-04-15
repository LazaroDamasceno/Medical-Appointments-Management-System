package com.api.v1.patient.find_all;

public class NoPatienttFoundException  extends RuntimeException {

    public NoPatienttFoundException() {
        super("No patient was found.");
    }
    
}