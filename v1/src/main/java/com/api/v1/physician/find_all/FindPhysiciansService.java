package com.api.v1.physician.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysiciansService implements FindPhysicians {

	private PhysicianRepository repository;

	@Override
	@Async
	public CompletableFuture<ResponseEntity<List<Physician>>> findAll() {
		return CompletableFuture.completedFuture(ResponseEntity.ok(repository.findAll()));
	}
	
}
