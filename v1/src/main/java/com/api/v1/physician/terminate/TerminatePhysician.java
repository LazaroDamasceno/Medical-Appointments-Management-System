package com.api.v1.physician.terminate;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface TerminatePhysician {

	ResponseEntity<Void> terminate(@NotNull @Size(min=7, max=7) String physicanLicenseNumber);
	
}
