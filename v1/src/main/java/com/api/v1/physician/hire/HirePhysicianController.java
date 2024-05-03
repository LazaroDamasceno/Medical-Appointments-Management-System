package com.api.v1.physician.hire;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class HirePhysicianController {
	
	private final HirePhysicianService service;

	@PostMapping
	@Transactional
	public HttpStatus register(@NotNull @RequestBody HirePhysicianDTO dto) {
		service.register(dto);
		return HttpStatus.CREATED;
	}

}
