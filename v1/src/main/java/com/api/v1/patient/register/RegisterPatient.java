package com.api.v1.patient.register;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface RegisterPatient {

	Future<ResponseEntity<Void>> register(@NotNull RegisterPatientDTO dto);
	
}
