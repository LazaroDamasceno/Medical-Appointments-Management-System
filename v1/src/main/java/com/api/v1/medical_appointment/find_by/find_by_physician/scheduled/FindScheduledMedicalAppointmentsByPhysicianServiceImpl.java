package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.patient.Patient;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPhysicianServiceImpl implements FindScheduledMedicalAppointmentsByPhysicianService {

    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    private final FindPatientBySsn findPatientBySsn;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber,
                                        @NotNull LocalDateTime firstDateTime, 
                                        @NotNull LocalDateTime lastDateTime
    ) {
        return findPhysicianByLicenseNumber
        .findByPhysicanLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null
                && e.getFinishingDateTime() == null
                && (e.getScheduledDateTime().isAfter(firstDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
                && (e.getScheduledDateTime().isBefore(lastDateTime) || e.getScheduledDateTime().isEqual(lastDateTime))
            )
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber,
                                                @NotNull @Size(min = 9, max = 9) String ssn, 
                                                @NotNull LocalDateTime firstDateTime,
                                                @NotNull LocalDateTime lastDateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        return findPhysicianByLicenseNumber
            .findByPhysicanLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null
                && e.getFinishingDateTime() == null
                && e.getPatient().equals(patient)
                && (e.getScheduledDateTime().isAfter(firstDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
                && (e.getScheduledDateTime().isAfter(lastDateTime) || e.getScheduledDateTime().isEqual(lastDateTime))
            )
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber) {
        return findPhysicianByLicenseNumber
            .findByPhysicanLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null && e.getFinishingDateTime() == null)
            .toList();
    }
    
}
