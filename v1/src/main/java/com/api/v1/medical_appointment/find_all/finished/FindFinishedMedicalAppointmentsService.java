package com.api.v1.medical_appointment.find_all.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;

import io.swagger.v3.oas.annotations.servers.Servers;
import lombok.RequiredArgsConstructor;

@Servers
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsService implements FindFinishedMedicalAppointments {

    private final MedicalAppointmentRepository repository;

    @Override
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> findAllFinished() {
        return ResponseEntity.ok(repository.findFinishedMedicalAppointments());
    }
    
}
