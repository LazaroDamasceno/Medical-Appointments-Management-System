package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.NoMedicalAppointmentFoundException;
import com.api.v1.patient.Patient;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPhysicianServiceImpl implements FindFinishedMedicalAppointmentsByPhysicianService {

    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(
            @NotNull @Size(min = 7, max = 7) String physicianLicenseNumber,
            @NotNull LocalDateTime firstDateTime, 
            @NotNull LocalDateTime lastDateTime
     ) {
        List<MedicalAppointment> medicalAppointments = findPhysicianByLicenseNumber
            .findByPhysicanLicenseNumber(physicianLicenseNumber)
            .getAppointmentList();
        validateInput(medicalAppointments);
        return medicalAppointments
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
                && (e.getScheduledDateTime().isAfter(firstDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
                && (e.getScheduledDateTime().isAfter(lastDateTime) || e.getScheduledDateTime().isEqual(lastDateTime))
            ).toList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(
            @NotNull @Size(min = 7, max = 7) String physicianLicenseNumber,
            @NotNull @Size(min = 9, max = 9) String ssn, 
            @NotNull LocalDateTime firstDateTime,
            @NotNull LocalDateTime lastDateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        List<MedicalAppointment> medicalAppointments = findPhysicianByLicenseNumber
            .findByPhysicanLicenseNumber(physicianLicenseNumber)
            .getAppointmentList();
        validateInput(medicalAppointments);
        return medicalAppointments
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
                && e.getPatient().equals(patient)
                && (e.getScheduledDateTime().isAfter(firstDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
                && (e.getScheduledDateTime().isAfter(lastDateTime) || e.getScheduledDateTime().isEqual(lastDateTime))
            ).toList();
    }

    private void validateInput(List<MedicalAppointment> medicalAppointments) {
        if (medicalAppointments.isEmpty()) throw new NoMedicalAppointmentFoundException();
    }
    
}
