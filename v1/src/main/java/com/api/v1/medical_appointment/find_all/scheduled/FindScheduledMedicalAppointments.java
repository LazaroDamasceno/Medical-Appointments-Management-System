package com.api.v1.medical_appointment.find_all.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindScheduledMedicalAppointments {

    ResponseEntity<List<MedicalAppointment>> findAllScheduled();
    
}
