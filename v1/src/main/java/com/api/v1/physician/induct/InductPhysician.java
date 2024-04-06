package com.api.v1.physician.induct;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface InductPhysician {
	
	CompletableFuture<ResponseEntity<Void>> register(@NotNull InductPhysicianDTO dto);

}
