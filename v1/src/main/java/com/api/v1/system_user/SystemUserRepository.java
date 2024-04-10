package com.api.v1.system_user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {

    @Modifying
	@Transactional
	@Query(value = "DROP TABLE IF EXISTS v1_system_user", nativeQuery = true)
	void dropTable();
    
}
