package com.api.v1.medical_record;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.patient.Patient;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, UUID> {

    Optional<MedicalRecord> findByPatient(Patient patient);

    @Modifying
	@Transactional
	@Query(value = "DROP TABLE IF EXISTS v1_medical_record", nativeQuery = true)
	void dropTable();
    
}
