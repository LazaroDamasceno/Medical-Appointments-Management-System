package com.api.v1.patient;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
	
	@Query("""
			select p from Patient p
			where p.systemUser.ssn = :ssn
	""")
	Optional<Patient> findPatientBySsn(@NotNull @Size(min=9, max=9) @Param("ssn") String ssn);

}
