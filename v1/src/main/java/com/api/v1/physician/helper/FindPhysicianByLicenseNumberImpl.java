package com.api.v1.physician.helper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysicianByLicenseNumberImpl implements FindPhysicianByLicenseNumber {

	private final PhysicianRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Physician findByphysicianLicenseNumber(@PhysicianLicenseNumber String physicianLicenseNumber) {
		validatedInput(physicianLicenseNumber);
		return repository.findByPhysicianLicenseNumber(physicianLicenseNumber).get();
	}
	
	private void validatedInput(String physicianLicenseNumber) {
		if (repository.findByPhysicianLicenseNumber(physicianLicenseNumber).isEmpty()) throw new PhysicianNotFoundException(physicianLicenseNumber);
	}

}
