package com.api.v1.medical_record.find_by_physician;

public class NoMedicalRecordFoundException extends RuntimeException {

    public NoMedicalRecordFoundException(String physicianLicenseNumber) {
        super("""
            No medical record related to the physician whose license number is %s was found.
        """.formatted(physicianLicenseNumber)
        );
    }
    
}
