package com.api.v1.medical_appointment.helper.find_by_patient;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.MedicalAppointmentNotFoundException;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByPatientImpl implements FindMedicalAppointmentByPatient {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsn findPatientBySsn;

    @Override
    @Transactional(readOnly = true)
    public MedicalAppointment findByPatient(@SSN String ssn, @NotNull LocalDateTime dateTime) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        Optional<MedicalAppointment> medicalAppointment = repository.findScheduledMedicalAppointmentByPatient(patient, dateTime);
        validateInput(medicalAppointment, dateTime.toString());
        return medicalAppointment.get();
    }
    
    private void validateInput(Optional<MedicalAppointment> optional, String dateTime) {
        if (optional.isEmpty()) throw new MedicalAppointmentNotFoundException(dateTime);
    }
}
