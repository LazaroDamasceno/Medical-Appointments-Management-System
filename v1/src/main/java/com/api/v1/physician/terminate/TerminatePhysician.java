package com.api.v1.physician.terminate;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface TerminatePhysician {

	ResponseEntity<Void> terminate(@NotBlank @Size(min=7, max=7) String mln);
	
}
