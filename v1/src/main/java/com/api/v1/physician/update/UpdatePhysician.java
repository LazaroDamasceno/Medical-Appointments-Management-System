package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface UpdatePhysician {

    ResponseEntity<Void> update(@NotNull UpdatePhysicianDTO dto);
    
}
