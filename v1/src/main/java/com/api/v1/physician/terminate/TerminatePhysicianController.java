package com.api.v1.physician.terminate;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class TerminatePhysicianController implements TerminatePhysician {
	
	private final TerminatePhysicianService service;
	
	@Override
	@PatchMapping
	public CompletableFuture<ResponseEntity<Void>> terminate(@NotBlank @Size(min = 7, max = 7) @PathVariable String mln) {
		return service.terminate(mln);
	}

}
