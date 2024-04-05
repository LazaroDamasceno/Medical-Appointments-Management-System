package com.api.v1.patient.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPatientsService implements FindPatients {
	
	private final PatientRepository repository;
	
	
	@Override
	@Async
	public CompletableFuture<ResponseEntity<List<Patient>>> findAll() {
		return CompletableFuture.completedFuture(ResponseEntity.ok(repository.findAll()));
	}
	
}
