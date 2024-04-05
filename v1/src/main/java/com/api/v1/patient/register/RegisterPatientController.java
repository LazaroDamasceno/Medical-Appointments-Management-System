package com.api.v1.patient.register;

import java.util.concurrent.Future;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class RegisterPatientController implements RegisterPatient {
	
	private final RegisterPatientService service;
	
	@Override
	@PostMapping
	@Async
	public Future<ResponseEntity<Void>> register(@NotNull @RequestBody RegisterPatientDTO dto) {
		return service.register(dto);
	}

}
