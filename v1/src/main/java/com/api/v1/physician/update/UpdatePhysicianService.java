package com.api.v1.physician.update;

import jakarta.validation.constraints.NotNull;

public interface UpdatePhysicianService {

    void update(@NotNull UpdatePhysicianDTO dto);
    
}
