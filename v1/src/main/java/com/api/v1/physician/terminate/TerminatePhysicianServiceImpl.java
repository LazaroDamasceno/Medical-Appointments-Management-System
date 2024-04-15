package com.api.v1.physician.terminate;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumberService;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TerminatePhysicianServiceImpl implements TerminatePhysicianService {
	
	private final PhysicianRepository repository;
	private final FindPhysicianByLicenseNumberService findPhysicianByLicenseNumber;

	@Override
	@Transactional
	public void terminate(@NotNull @Size(min = 7, max = 7) String physicanLicenseNumber) {
		Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(physicanLicenseNumber);
		LocalDateTime now = LocalDateTime.now();
		physician.setTerminationDateTime(now);
		repository.save(physician);
	}

}
