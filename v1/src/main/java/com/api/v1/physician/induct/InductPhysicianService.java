package com.api.v1.physician.induct;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.constants.AsyncHttpStatus;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InductPhysicianService implements InductPhysician {
	
	private final PhysicianRepository repository;
	
	@Override
	@Async
	public CompletableFuture<ResponseEntity<Void>> register(@NotNull InductPhysicianDTO dto) {
		validateInput(dto.mln());
		Physician physician = new Physician(dto);
		repository.save(physician);
		return AsyncHttpStatus.CREATED_201;
	}
	
	private void validateInput(String mln) {
		if (repository.findByMln(mln).isPresent()) {
			throw new DuplicatedPhysicianException(mln);
		}
	}

}
