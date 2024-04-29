package com.api.v1.physician.terminate;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TerminatePhysicianServiceImpl implements TerminatePhysicianService {
	
	private final PhysicianRepository repository;
	private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

	@Override
	@Transactional
	public void terminate(@PhysicianLicenseNumber String physicianLicenseNumber) {
		Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
		ZonedDateTime now = ZonedDateTime.now();
		physician.setTerminationDateTime(now);
		repository.save(physician);
	}

}
