package com.api.v1.patient.update;

import jakarta.validation.constraints.NotNull;

public interface UpdatePatientService {

    void update( @NotNull UpdatePatientDTO dto);
    
}
