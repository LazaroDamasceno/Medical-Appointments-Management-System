package com.api.v1.physician.terminate;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TerminatePhysicianServiceImpl implements TerminatePhysicianService {
	
	private final PhysicianRepository repository;
	private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

	@Override
	@Transactional
	@Cacheable
	public void terminate(@PhysicianLicenseNumber String physicianLicenseNumber) {
		Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
		LocalDateTime now = LocalDateTime.now();
		physician.setTerminationDateTime(now);
		repository.save(physician);
	}

}
