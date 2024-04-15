package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_record.MedicalRecord;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-record-by-physician")
@RequiredArgsConstructor
public class FindMedicalRecordsByPhysicianController implements FindMedicalRecordsByPhysician {
    
    private final FindMedicalRecordsByPhysicianService service;

    @Override
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalRecord>> findByPhysicianLicenseNumber(@NotNull @RequestBody PhysicianLicenseNumberDTO dto) {
        return service.findByPhysicianLicenseNumber(dto);
    }

}
