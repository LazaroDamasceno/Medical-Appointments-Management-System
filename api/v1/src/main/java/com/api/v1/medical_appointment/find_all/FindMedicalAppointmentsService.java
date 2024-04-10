package com.api.v1.medical_appointment.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentsService implements FindMedicalAppointments {

    private final MedicalAppointmentRepository repository;

    @Override
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
    
}
