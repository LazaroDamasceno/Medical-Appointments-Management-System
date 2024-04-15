package com.api.v1.physician.find_all;

public class NoPhysicianFoundException extends RuntimeException {

    public NoPhysicianFoundException() {
        super("No physician was found.");
    }
    
}
