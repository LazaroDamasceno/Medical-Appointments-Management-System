package com.api.v1.patient.register;

import org.springframework.http.HttpStatus;
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
public class RegisterPatientController {
	
	private final RegisterPatientService service;
	
	@PostMapping
	@Transactional
	public HttpStatus register(@NotNull @RequestBody RegisterPatientDTO dto) {
		service.register(dto);
		return HttpStatus.CREATED;
	}

}
