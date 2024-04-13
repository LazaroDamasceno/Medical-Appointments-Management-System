package com.api.v1.medical_record.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_record.MedicalRecord;

public interface FindMedicalRecords {

    ResponseEntity<List<MedicalRecord>> findAll();
    
}
