package com.api.v1.medical_appointment.find.scheduled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsServiceImpl implements FindScheduledMedicalAppointmentsService {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(@SSN String ssn, @NotNull LocalDateTime firstDateTime, @NotNull LocalDateTime lastDateTime) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        return repository.getScheduledMedicalAppointmentsByPatient(patient, firstDateTime, lastDateTime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPhysicians(@PhysicianLicenseNumber String physicianLicenseNumber, @NotNull LocalDateTime firstDateTime, @NotNull LocalDateTime lastDateTime) {
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        return repository.getScheduledMedicalAppointmentsByPhysician(physician, firstDateTime, lastDateTime);
    }
    
}
