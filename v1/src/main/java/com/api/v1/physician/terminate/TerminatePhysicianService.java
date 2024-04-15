package com.api.v1.physician.terminate;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.find_by_mln.FindPhysicianByMlnService;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TerminatePhysicianService implements TerminatePhysician {
	
	private final PhysicianRepository repository;
	private final FindPhysicianByMlnService findPhysicianByMln;

	@Override
	@Transactional
	public ResponseEntity<Void> terminate(@NotNull @Size(min = 7, max = 7) String physicanLicenseNumber) {
		Physician physician = findPhysicianByMln.findByMln(physicanLicenseNumber);
		LocalDateTime now = LocalDateTime.now();
		physician.setTerminationDateTime(now);
		repository.save(physician);
		return HttpStatusCodes.NO_CONTENT_204;
	}

}
