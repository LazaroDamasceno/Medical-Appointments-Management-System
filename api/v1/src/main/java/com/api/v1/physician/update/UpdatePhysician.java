package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;

import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.validation.constraints.NotNull;

public interface UpdatePhysician {

    ResponseEntity<Void> update(@NotNull UpdatedSystemUserDTO dto);
    
}
