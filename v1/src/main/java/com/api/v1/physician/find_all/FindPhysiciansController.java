package com.api.v1.physician.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.physician.Physician;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physicians")
@RequiredArgsConstructor
public class FindPhysiciansController implements FindPhysicians {
	
	private final FindPhysiciansService service;

	@Override
	@GetMapping
	@Transactional(readOnly = true)
	public ResponseEntity<List<Physician>> findAll() {
		return service.findAll();
	}

}
