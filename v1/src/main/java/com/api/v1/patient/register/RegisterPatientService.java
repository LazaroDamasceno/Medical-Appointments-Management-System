package com.api.v1.patient.register;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.api.v1.constants.AsyncHttpStatus;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterPatientService implements RegisterPatient {

	private final PatientRepository repository;
	
	@Override
	@Async
	@Transactional
	public CompletableFuture<ResponseEntity<Void>> register(@NotNull RegisterPatientDTO dto) {
		validateInput(dto.systemUser().ssn());
		Patient patient = new Patient(dto);
		repository.save(patient);
		return AsyncHttpStatus.CREATED_201;
	}
	
	private void validateInput(String ssn) {
		if (Objects.nonNull(repository.findPatientBySsn(ssn))) {
			throw new DuplicatedPatientException(ssn);
		}
	}
	
}
