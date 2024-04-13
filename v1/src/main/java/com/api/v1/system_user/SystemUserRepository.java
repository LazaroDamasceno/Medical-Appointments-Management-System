package com.api.v1.system_user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, UUID> {

}
