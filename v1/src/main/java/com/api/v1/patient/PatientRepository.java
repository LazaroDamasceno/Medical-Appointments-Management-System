package com.api.v1.patient;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
	
	@Query("""
			select p from Patient p
			where p.systemUser.ssn = :ssn
	""")
	Patient findPatientBySsn(@NotBlank @Size(min=9, max=9) @Param("ssn") String ssn);

}
