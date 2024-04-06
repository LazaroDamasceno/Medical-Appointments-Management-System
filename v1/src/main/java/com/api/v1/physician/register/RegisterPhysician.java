package com.api.v1.physician.register;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface RegisterPhysician {
	
	CompletableFuture<ResponseEntity<Void>> register(@NotNull RegisterPhysicianDTO dto);

}
