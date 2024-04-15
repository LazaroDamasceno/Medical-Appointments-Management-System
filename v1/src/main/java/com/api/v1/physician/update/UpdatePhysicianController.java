package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.constraints.NotNull;

public interface UpdatePhysicianController {

    public ResponseEntity<Void> update(@NotNull @RequestBody UpdatePhysicianDTO dto);
    
}
