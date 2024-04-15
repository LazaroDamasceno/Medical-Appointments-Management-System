package com.api.v1.medical_appointment.schedule;

import jakarta.validation.constraints.NotNull;

public interface ScheduleMedicalAppointmentService {

    void schedule(@NotNull ScheduleMedicalAppointmentDTO dto);
    
} 
