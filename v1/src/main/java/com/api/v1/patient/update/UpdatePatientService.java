package com.api.v1.patient.update;

import jakarta.validation.constraints.NotNull;

interface UpdatePatientService {

    void update( @NotNull UpdatePatientDTO dto);
    
}
