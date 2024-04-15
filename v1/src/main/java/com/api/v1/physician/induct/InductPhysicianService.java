package com.api.v1.physician.induct;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InductPhysicianService implements InductPhysician {
	
	private final PhysicianRepository repository;
	
	@Override
	@Transactional
	public ResponseEntity<Void> register(@NotNull InductPhysicianDTO dto) {
		validateInput(dto.physicanLicenseNumber());
		Physician physician = new Physician(dto);
		repository.save(physician);
		return HttpStatusCodes.CREATED_201;
	}
	
	private void validateInput(String physicanLicenseNumber) {
		if (repository.findByLicenseNumber(physicanLicenseNumber).isPresent()) {
			throw new DuplicatedPhysicianException(physicanLicenseNumber);
		}
	}

}
