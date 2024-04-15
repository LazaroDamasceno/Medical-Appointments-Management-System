package com.api.v1.physician.induct;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface InductPhysicianController {

	public ResponseEntity<Void> register(@NotNull InductPhysicianDTO dto);
    
}
