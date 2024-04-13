package com.api.v1.medical_record.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_record.MedicalRecord;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-records")
@RequiredArgsConstructor
public class FindMedicalRecordsController implements FindMedicalRecords {

    private final FindMedicalRecordsService service;

    @Override
    @GetMapping
    @Transactional
    public ResponseEntity<List<MedicalRecord>> findAll() {
        return service.findAll();
    }
    
}
