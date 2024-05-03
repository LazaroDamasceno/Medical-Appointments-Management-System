package com.api.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.v1.physician.PhysicianRepository;

@SpringBootTest
class DoesPhysicianExistTest {

    @Autowired
    private PhysicianRepository physicianRepository;

    @Test
    void doesPatientExist() {
        String licenseNumber = "1234567";
        boolean doesPhysicianExist = physicianRepository.findByPhysicianLicenseNumber(licenseNumber).isPresent();
        assertEquals(true, doesPhysicianExist);
    }

}
