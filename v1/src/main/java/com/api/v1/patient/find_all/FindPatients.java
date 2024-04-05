package com.api.v1.patient.find_all;

import java.util.concurrent.CompletableFuture;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.patient.Patient;

public interface FindPatients {
	
	CompletableFuture<ResponseEntity<List<Patient>>> findAll();

}
