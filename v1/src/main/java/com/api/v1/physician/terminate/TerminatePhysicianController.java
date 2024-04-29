package com.api.v1.physician.terminate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helper.constants.HttpStatusCodes;
import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class TerminatePhysicianController {
	
	private final TerminatePhysicianServiceImpl service;
	
	@PatchMapping("{physicianLicenseNumber}")
	@Transactional
	public ResponseEntity<Void> terminate(@PathVariable @PhysicianLicenseNumber String physicianLicenseNumber) {
		service.terminate(physicianLicenseNumber);
		return HttpStatusCodes.NO_CONTENT_204;
	}

}
