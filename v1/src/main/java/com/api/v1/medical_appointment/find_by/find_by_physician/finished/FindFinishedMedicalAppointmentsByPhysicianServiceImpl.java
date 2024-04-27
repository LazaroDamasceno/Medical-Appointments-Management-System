package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.auxiliary.DateTimeConverter;
import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.BetweenDatesTimesDTO;
import com.api.v1.patient.Patient;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPhysicianServiceImpl implements FindFinishedMedicalAppointmentsByPhysicianService {

    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(
            @PhysicianLicenseNumber String physicianLicenseNumber,
            @NotNull BetweenDatesTimesDTO dto
    ) {
        LocalDateTime ldt1 = DateTimeConverter.convertToDateTime(dto.firstDateTime());
        LocalDateTime ldt2 = DateTimeConverter.convertToDateTime(dto.lastDateTime());
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
                && (e.getScheduledDateTime().isAfter(ldt1) || e.getScheduledDateTime().isEqual(ldt1))
                && (e.getScheduledDateTime().isBefore(ldt2) || e.getScheduledDateTime().isEqual(ldt2))
            ).toList();

    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(
            @PhysicianLicenseNumber String physicianLicenseNumber,
            @SSN String ssn, 
            @NotNull BetweenDatesTimesDTO dto
    ) {
        LocalDateTime ldt1 = DateTimeConverter.convertToDateTime(dto.firstDateTime());
        LocalDateTime ldt2 = DateTimeConverter.convertToDateTime(dto.lastDateTime());
        Patient patient = findPatientBySsn.findBySsn(ssn);
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
                && e.getPatient().equals(patient)
                && (e.getScheduledDateTime().isAfter(ldt1) || e.getScheduledDateTime().isEqual(ldt1))
                && (e.getScheduledDateTime().isBefore(ldt2) || e.getScheduledDateTime().isEqual(ldt2))
            ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@PhysicianLicenseNumber  String physicianLicenseNumber) {
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getFinishingDateTime() != null)
            .toList();
    }

    
}
