package com.api.v1.physician.find_all;

public class NoPhysicianWasFoundException extends RuntimeException {

    public NoPhysicianWasFoundException() {
        super("No physician was found.");
    }
    
}
