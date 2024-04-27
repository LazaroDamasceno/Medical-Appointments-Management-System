package com.api.v1.physician.hire;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helper.constant.HttpStatusCodes;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
class HirePhysicianController {
	
	private final HirePhysicianService service;

	@PostMapping
	@Transactional
	public ResponseEntity<Void> register(@NotNull @RequestBody HirePhysicianDTO dto) {
		service.register(dto);
		return HttpStatusCodes.CREATED_201;
	}

}
