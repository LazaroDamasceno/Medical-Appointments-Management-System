package com.api.v1.medical_appointment.find_all.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindCanceledMedicalAppointments {

    ResponseEntity<List<MedicalAppointment>> findAllCanceled();
    
}
