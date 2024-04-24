package com.api.v1.patient.register;

import jakarta.validation.constraints.NotNull;

interface RegisterPatientService {
    
    void register(@NotNull RegisterPatientDTO dto);

}
