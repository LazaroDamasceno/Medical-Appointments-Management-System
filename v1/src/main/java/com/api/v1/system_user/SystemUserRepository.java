package com.api.v1.system_user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {
	
	Optional<SystemUser> findBySsn(@NotBlank @Size(min=9, max=9) String ssn);

}
