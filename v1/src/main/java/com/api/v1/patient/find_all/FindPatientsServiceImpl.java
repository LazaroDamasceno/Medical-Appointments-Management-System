package com.api.v1.patient.find_all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPatientsServiceImpl implements FindPatientsService {
	
	private final PatientRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	@Cacheable
	public List<Patient> findAll() {
		return repository.findAll();
	}
	
}
