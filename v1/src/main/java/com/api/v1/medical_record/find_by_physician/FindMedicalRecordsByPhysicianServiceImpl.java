package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_record.MedicalRecord;
import com.api.v1.medical_record.MedicalRecordRepository;
import com.api.v1.physician.Physician;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class FindMedicalRecordsByPhysicianServiceImpl implements FindMedicalRecordsByPhysicianService {

    private final MedicalRecordRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalRecord> findByPhysicianLicenseNumber(@PhysicianLicenseNumber String physicianLicenseNumber) {
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        return repository
                .findAll()
                .stream()
                .filter(e -> e.getPhysician().equals(physician))
                .toList();
    }
    
}
