package com.api.v1.physician.hire;

import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HirePhysicianServiceImpl implements HirePhysicianService {
	
	private final PhysicianRepository repository;
	
	@Override
	@Transactional
	public void register(@NotNull HirePhysicianDTO dto) {
		validateInput(dto.physicianLicenseNumber());
		Physician physician = new Physician(dto);
		repository.save(physician);
	}
	
	private void validateInput(String physicianLicenseNumber) {
		if (repository.findByPhysicianLicenseNumber(physicianLicenseNumber).isPresent()) {
			throw new DuplicatedPhysicianException(physicianLicenseNumber);
		}
	}

}
