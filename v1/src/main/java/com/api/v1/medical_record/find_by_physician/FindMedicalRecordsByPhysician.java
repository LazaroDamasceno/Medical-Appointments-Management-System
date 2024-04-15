package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_record.MedicalRecord;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalRecordsByPhysician {

    ResponseEntity<List<MedicalRecord>> findByPhysicianLicenseNumber(@NotNull PhysicianLicenseNumberDTO dto);
    
}
