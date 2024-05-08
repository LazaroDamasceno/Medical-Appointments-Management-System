package com.api.v1.patient.register;

import org.springframework.stereotype.Service;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterPatientServiceImpl implements RegisterPatientService {

	private final PatientRepository repository;
	
	@Override
	@Transactional
	public void register(@NotNull RegisterPatientDTO dto) {
		validateInput(dto.systemUser().ssn());
		Patient patient = new Patient(dto);
		repository.save(patient);
	}
	
	private void validateInput(String ssn) {
		if (repository.findPatientBySsn(ssn).isPresent()) {
			throw new DuplicatedPatientException(ssn);
		}
	}
	
}
