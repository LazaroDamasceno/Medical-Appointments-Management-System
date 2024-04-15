package com.api.v1.patient.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.patient.Patient;

public interface FindPatientsController {

    public ResponseEntity<List<Patient>> findAll();
    
}
