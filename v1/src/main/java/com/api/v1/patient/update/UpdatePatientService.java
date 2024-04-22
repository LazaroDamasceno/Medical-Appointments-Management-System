package com.api.v1.patient.update;

import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.NotNull;

public interface UpdatePatientService {

    void update(@SSN String ssn, @NotNull UpdatePatientDTO dto);
    
}
