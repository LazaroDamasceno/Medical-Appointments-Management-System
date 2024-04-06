package com.api.v1.physician.register;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class RegisterPhysicianController implements RegisterPhysician {
	
	private final RegisterPhysicianService service;

	@Override
	@PostMapping
	public CompletableFuture<ResponseEntity<Void>> register(@NotNull @RequestBody RegisterPhysicianDTO dto) {
		return service.register(dto);
	}

}
