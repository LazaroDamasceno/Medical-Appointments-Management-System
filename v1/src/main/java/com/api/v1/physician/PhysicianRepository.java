package com.api.v1.physician;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {
	
	Optional<Physician> findByPhysicianLicenseNumber(@NotNull @Size(min=9, max=9) String physicanLicenseNumber);

}
