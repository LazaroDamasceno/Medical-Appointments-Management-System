package com.api.v1.patient.register;

import jakarta.validation.constraints.NotNull;

public interface RegisterPatientService {
    
    void register(@NotNull RegisterPatientDTO dto);

}
