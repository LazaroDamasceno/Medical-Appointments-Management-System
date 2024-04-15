package com.api.v1.medical_appointment.find_by_patient.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputDTO;
import com.api.v1.medical_appointment.find_by_patient.NoMedicalAppointmentFoundException;
import com.api.v1.medical_appointment.internal_user.find_between_dates.FindMedicalAppointmentsBetweenDates;
import com.api.v1.patient.Patient;
import com.api.v1.patient.find_by_ssn.FindPatientBySsn;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentByPatientService implements FindCanceledMedicalAppointmentByPatient {

    private final FindPatientBySsn findPatientBySsn;
    private final FindMedicalAppointmentsBetweenDates findMedicalAppointmentsBetweenDates;

    @Override
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> findAll(@NotNull MedicalAppointmentInputDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        List<MedicalAppointment> medicalAppointments = findMedicalAppointmentsBetweenDates.findAll(dto.betweenDatesDTO());
        if (medicalAppointments.isEmpty()) throw new NoMedicalAppointmentFoundException();
        return ResponseEntity.ok(
            medicalAppointments
                .stream()
                .filter(e -> e.getPatient().equals(patient) 
                    && e.getCancelationDateTime() != null
                ).toList()
        );
    }
    
}
