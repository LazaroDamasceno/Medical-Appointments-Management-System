package com.api.v1.medical_record.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_record.MedicalRecord;
import com.api.v1.medical_record.MedicalRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalRecordsService implements FindMedicalRecords {

    private final MedicalRecordRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalRecord>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
}
