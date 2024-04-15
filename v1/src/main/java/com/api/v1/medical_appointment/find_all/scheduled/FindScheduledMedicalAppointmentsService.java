package com.api.v1.medical_appointment.find_all.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_all.NoMedicalAppointmentFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsService implements FindScheduledMedicalAppointments {

    private final MedicalAppointmentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findAllScheduled() {
        List<MedicalAppointment> medicalAppointments = repository.findScheduledMedicalAppointments();
        if (medicalAppointments.isEmpty()) throw new NoMedicalAppointmentFoundException();
        return ResponseEntity.ok(medicalAppointments);
    }
    
}
