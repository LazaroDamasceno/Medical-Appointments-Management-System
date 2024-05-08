package com.api.v1.physician.terminate;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.PhysicianLicenseNumber;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class TerminatePhysicianController {
	
	private final TerminatePhysicianServiceImpl service;
	
	@PatchMapping("{physicianLicenseNumber}")
	@Transactional
	public ResponseEntity<String> terminate(@PathVariable @PhysicianLicenseNumber String physicianLicenseNumber) {
		service.terminate(physicianLicenseNumber);
		String message = "Physician whose license number is %s was terminated.".formatted(physicianLicenseNumber);
		return ResponseEntity.status(204).body(message);
	}

}
