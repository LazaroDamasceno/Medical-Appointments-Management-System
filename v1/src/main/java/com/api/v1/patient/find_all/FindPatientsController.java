package com.api.v1.patient.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.patient.Patient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patients")
@RequiredArgsConstructor
public class FindPatientsController implements FindPatients {
	
	private final FindPatientsService service;

	@Override
	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<List<Patient>> findAll() {
		return service.findAll();
	}

}
