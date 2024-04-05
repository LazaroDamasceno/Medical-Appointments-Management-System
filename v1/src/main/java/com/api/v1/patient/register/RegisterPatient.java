package com.api.v1.patient.register;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

public interface RegisterPatient {

	CompletableFuture<ResponseEntity<Void>> register(RegisterPatientDTO dto);
	
}
