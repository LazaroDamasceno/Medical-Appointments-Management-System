package com.api.v1.medical_appointment.find_all.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindFinishedMedicalAppointments {
    
    ResponseEntity<List<MedicalAppointment>> findAllFinished();

}
