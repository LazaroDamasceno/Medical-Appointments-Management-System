package com.api.v1.medical_record.find_by_physician;

import java.util.List;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_record.MedicalRecord;

interface FindMedicalRecordsByPhysicianService {

    List<MedicalRecord> findByPhysicianLicenseNumber(@PhysicianLicenseNumber String physicianLicenseNumber);
    
}
