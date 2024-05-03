package com.api.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.v1.patient.PatientRepository;

@SpringBootTest
class DoesPatientExistTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void doesPatientExist() {
        String ssn = "123456789";
        boolean doesPhysicianExist = patientRepository.findPatientBySsn(ssn).isPresent();
        assertEquals(true, doesPhysicianExist);
    }

}
