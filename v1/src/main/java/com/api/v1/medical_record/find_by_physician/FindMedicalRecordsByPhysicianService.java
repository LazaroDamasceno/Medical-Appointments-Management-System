package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_record.MedicalRecord;
import com.api.v1.medical_record.MedicalRecordRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalRecordsByPhysicianService implements FindMedicalRecordsByPhysician {

    private final MedicalRecordRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalRecord>> findByPhysicianLicenseNumber(@NotNull PhysicianLicenseNumberDTO dto) {
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(dto.physicianLicenseNumber());
        List<MedicalRecord> medicalRecords = repository.findAll();
        if (medicalRecords.isEmpty()) throw new NoMedicalRecordFoundException(dto.physicianLicenseNumber());
        return ResponseEntity.ok(
            repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician))
                .toList()
        );
    }
    
}
