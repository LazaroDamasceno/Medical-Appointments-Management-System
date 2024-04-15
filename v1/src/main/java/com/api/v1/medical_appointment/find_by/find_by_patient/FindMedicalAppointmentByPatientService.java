package com.api.v1.medical_appointment.find_by.find_by_patient;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_by.MedicalAppointmentNotFoundException;
import com.api.v1.patient.Patient;
import com.api.v1.patient.find_by_ssn.FindPatientBySsnService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByPatientService implements FindMedicalAppointmentByPatient {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsnService findPatientBySsn;

    @Override
    @Transactional(readOnly = true)
    public MedicalAppointment findByPatient(@NotNull @Size(min = 9, max = 9) String ssn, @NotNull LocalDateTime dateTime) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        validateInput(patient, dateTime);
        return repository.findScheduledMedicalAppointmentByPatient(patient, dateTime);
    }
    
    private void validateInput(Patient patient, LocalDateTime date) {
        if (repository.findScheduledMedicalAppointmentByPatient(patient, date) == null) {
            throw new MedicalAppointmentNotFoundException(patient, date);
        }
    }

}
