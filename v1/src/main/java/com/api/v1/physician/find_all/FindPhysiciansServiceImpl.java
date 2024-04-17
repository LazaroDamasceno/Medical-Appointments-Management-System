package com.api.v1.physician.find_all;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPhysiciansServiceImpl implements FindPhysiciansService {

	private final PhysicianRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Physician> findAll() {
		return repository.findAll();
	}
	
}

