package com.api.v1.find_all;

import java.util.concurrent.Future;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.patient.Patient;

public interface FindPatients {
	
	Future<ResponseEntity<List<Patient>>> findAll();

}
