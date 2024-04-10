package com.api.v1.medical_appointment.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindMedicalAppointments {

    ResponseEntity<List<MedicalAppointment>> findAll();
    
}
