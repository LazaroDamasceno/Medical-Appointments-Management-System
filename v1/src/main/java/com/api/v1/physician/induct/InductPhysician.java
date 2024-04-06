package com.api.v1.physician.induct;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface InductPhysician {
	
	ResponseEntity<Void> register(@NotNull InductPhysicianDTO dto);

}
