package com.api.v1.physician.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysiciansService implements FindPhysicians {

	private final PhysicianRepository repository;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<Physician>> findAll() {
		List<Physician> physicians = repository.findAll();
		if (physicians.isEmpty()) throw new NoPhysicianWasFoundException();
		return ResponseEntity.ok(repository.findAll());
	}
	
}

