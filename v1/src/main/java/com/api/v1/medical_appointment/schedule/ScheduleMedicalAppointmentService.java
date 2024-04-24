package com.api.v1.medical_appointment.schedule;

import jakarta.validation.constraints.NotNull;

interface ScheduleMedicalAppointmentService {

    void schedule(@NotNull ScheduleMedicalAppointmentDTO dto);
    
} 
