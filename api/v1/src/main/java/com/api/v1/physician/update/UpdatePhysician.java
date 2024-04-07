package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;

import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface UpdatePhysician {

    ResponseEntity<Void> update(@NotNull @Size(min = 7, max = 7) String mln, @NotNull UpdatedSystemUserDTO dto);
    
}
