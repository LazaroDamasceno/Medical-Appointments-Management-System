package com.api.v1.physician.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysiciansService implements FindPhysicians {

	private final PhysicianRepository repository;

	@Override

	public ResponseEntity<List<Physician>> findAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
}

