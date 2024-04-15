package com.api.v1.patient.internal_use;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPatientBySsnService implements FindPatientBySsn {

	private final PatientRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Patient findBySsn(@NotNull @Size(min = 9, max = 9) String ssn) {
		validateInput(ssn);
		return repository.findPatientBySsn(ssn);
	}
	
	private void validateInput(String ssn) {
		if (repository.findPatientBySsn(ssn) == null) {
			throw new PatientNotFoundException(ssn);
		}
	}

}
