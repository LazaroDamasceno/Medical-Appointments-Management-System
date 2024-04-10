package com.api.v1.physician.induct;

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
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class InductPhysicianController implements InductPhysician {
	
	private final InductPhysicianService service;

	@Override
	@PostMapping
	@Transactional
	public ResponseEntity<Void> register(@NotNull @RequestBody InductPhysicianDTO dto) {
		return service.register(dto);
	}

}
