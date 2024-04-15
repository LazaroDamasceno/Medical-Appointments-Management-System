package com.api.v1.patient.find_all;

public class NoPatientWasFoundException  extends RuntimeException {

    public NoPatientWasFoundException() {
        super("No patient was found.");
    }
    
}