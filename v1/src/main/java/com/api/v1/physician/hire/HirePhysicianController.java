package com.api.v1.physician.hire;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<String> register(@NotNull @RequestBody HirePhysicianDTO dto) {
		service.register(dto);
		return ResponseEntity.status(201).body(Constants.CREATED_201);
	}

}
