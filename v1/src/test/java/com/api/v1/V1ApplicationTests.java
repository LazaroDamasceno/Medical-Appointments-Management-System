package com.api.v1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.v1.patient.PatientRepository;
import com.api.v1.physician.PhysicianRepository;

@SpringBootTest
class V1ApplicationTests {

	@Autowired
	private PhysicianRepository physicianRepository;

	@Test
	void doesPhysicianExist() {
		boolean doesPhysicianExist = physicianRepository
			.findByPhysicianLicenseNumber("1234567")
			.isPresent();
		assertEquals(true, doesPhysicianExist);
	}

	@Autowired
	private PatientRepository patientRepository;

	@Test
	void doesPatientExist() {
		var doesPatientExist = patientRepository.findPatientBySsn("123456789").isPresent();
		assertEquals(true, doesPatientExist);
	}

}
