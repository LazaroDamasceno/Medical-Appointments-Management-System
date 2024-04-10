package com.api.v1.patient.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class RegisterPatientController implements RegisterPatient {
	
	private final RegisterPatientService service;
	
	@Override
	@PostMapping
	@Transactional
	public ResponseEntity<Void> register(@NotNull @RequestBody RegisterPatientDTO dto) {
		return service.register(dto);
	}

}
