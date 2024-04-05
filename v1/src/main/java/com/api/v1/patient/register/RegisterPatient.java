package com.api.v1.patient.register;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface RegisterPatient {

	CompletableFuture<ResponseEntity<Void>> register(@NotNull RegisterPatientDTO dto);
	
}
