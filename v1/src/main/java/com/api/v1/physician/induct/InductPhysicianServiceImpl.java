package com.api.v1.physician.induct;

import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InductPhysicianServiceImpl implements InductPhysicianService {
	
	private final PhysicianRepository repository;
	
	@Override
	@Transactional
	public void register(@NotNull InductPhysicianDTO dto) {
		validateInput(dto.physicanLicenseNumber());
		Physician physician = new Physician(dto);
		repository.save(physician);
	}
	
	private void validateInput(String physicanLicenseNumber) {
		if (repository.findByPhysicianLicenseNumber(physicanLicenseNumber).isPresent()) {
			throw new DuplicatedPhysicianException(physicanLicenseNumber);
		}
	}

}
