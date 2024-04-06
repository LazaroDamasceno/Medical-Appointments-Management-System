package com.api.v1.physician.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.physician.Physician;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physicians")
@RequiredArgsConstructor
public class FindPhysiciansController implements FindPhysicians {
	
	private final FindPhysiciansService service;

	@Override
	@GetMapping
	public CompletableFuture<ResponseEntity<List<Physician>>> findAll() {
		return service.findAll();
	}

}
