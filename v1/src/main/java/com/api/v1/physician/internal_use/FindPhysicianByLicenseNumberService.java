package com.api.v1.physician.internal_use;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysicianByLicenseNumberService implements FindPhysicianByLicenseNumber {

	private final PhysicianRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Physician findByPhysicanLicenseNumber(@NotNull @Size(min = 7, max = 7) String physicanLicenseNumber) {
		validatedInput(physicanLicenseNumber);
		return repository.findByPhysicianLicenseNumber(physicanLicenseNumber).get();
	}
	
	private void validatedInput(String physicanLicenseNumber) {
		if (repository.findByPhysicianLicenseNumber(physicanLicenseNumber).isEmpty()) throw new PhysicianNotFoundException(physicanLicenseNumber);
	}

}
