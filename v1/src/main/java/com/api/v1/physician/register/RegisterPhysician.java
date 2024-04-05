package com.api.v1.physician.register;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

public interface RegisterPhysician {
	
	CompletableFuture<ResponseEntity<Void>> register(RegisterPhysicianDTO dto);

}
