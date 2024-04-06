package com.api.v1.physician.induct;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class InductPhysicianController implements InductPhysician {
	
	private final InductPhysicianService service;

	@Override
	@PostMapping
	@Async
	public CompletableFuture<ResponseEntity<Void>> register(@NotNull @RequestBody InductPhysicianDTO dto) {
		return service.register(dto);
	}

}
