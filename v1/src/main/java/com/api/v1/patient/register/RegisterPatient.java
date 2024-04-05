package com.api.v1.patient.register;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;

import jakarta.validation.constraints.NotNull;

public interface RegisterPatient {

	@Async
	Future<ResponseEntity<Void>> register(@NotNull RegisterPatientDTO dto);
	
}
