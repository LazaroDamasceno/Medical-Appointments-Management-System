package com.api.v1.medical_appointment.find_all.canceled;

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
public class FindCanceledMedicalAppointmentsService implements FindCanceledMedicalAppointments {

    private final MedicalAppointmentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findAllCanceled() {
        List<MedicalAppointment> medicalAppointments = repository.findCanceledMedicalAppointments();
        if (medicalAppointments.isEmpty()) throw new NoMedicalAppointmentFoundException();
        return ResponseEntity.ok(medicalAppointments);
    }
    
}
