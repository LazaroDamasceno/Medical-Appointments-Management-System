package com.api.v1.patient.register;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.constants.HttpStatusCodes;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
class RegisterPatientController {
	
	private final RegisterPatientService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<Void> register(@NotNull @RequestBody RegisterPatientDTO dto) {
		service.register(dto);
		return HttpStatusCodes.CREATED_201;
	}

}
