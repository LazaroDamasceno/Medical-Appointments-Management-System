package com.api.v1.medical_appointment.add_medical_notes;

import jakarta.validation.constraints.NotNull;

public interface AddMedicalNotesService {
    
    void add(@NotNull MedicalNotesDTO dto);

}
