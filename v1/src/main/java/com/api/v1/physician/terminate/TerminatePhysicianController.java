package com.api.v1.physician.terminate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class TerminatePhysicianController implements TerminatePhysician {
	
	private final TerminatePhysicianService service;
	
	@Override
	@PatchMapping("{mln}")
	@Transactional
	public ResponseEntity<Void> terminate(@NotNull @Size(min = 7, max = 7) @PathVariable String mln) {
		return service.terminate(mln);
	}

}
