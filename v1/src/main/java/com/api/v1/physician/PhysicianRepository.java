package com.api.v1.physician;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface PhysicianRepository extends JpaRepository<Physician, UUID> {
	
	Optional<Physician> findByMln(@NotNull @Size(min=9, max=9) String mln);

	@Modifying
	@Transactional
	@Query(value = "DROP TABLE IF EXISTS v1_physician", nativeQuery = true)
	void dropTable();

}
