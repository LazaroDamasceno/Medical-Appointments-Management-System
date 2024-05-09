package com.api.v1.patient.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patients")
@RequiredArgsConstructor
public class RegisterPatientController {
	
	private final RegisterPatientService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<String> register(@NotNull @RequestBody RegisterPatientDTO dto) {
		service.register(dto);
		return ResponseEntity.status(201).body(Constants.CREATED_201);
	}

}
