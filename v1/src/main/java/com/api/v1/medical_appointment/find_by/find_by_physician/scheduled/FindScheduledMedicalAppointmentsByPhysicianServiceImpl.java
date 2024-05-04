package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.DateTimeConverter;
import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;
import com.api.v1.medical_appointment.find_by.helper.CheckIfDateTimesAreValid;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPhysicianServiceImpl implements FindScheduledMedicalAppointmentsByPhysicianService {

    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    private final FindPatientBySsn findPatientBySsn;
    private final CheckIfDateTimesAreValid checkIfDateTimesAreValid;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@PhysicianLicenseNumber String physicianLicenseNumber,
                                            @NotNull BetweenDatesTimesDTO dto   
    ) {
        validateDateTimes(dto);
        LocalDateTime ldt1 = DateTimeConverter.convertToLocalDateTime(dto.firstDateTime());
        LocalDateTime ldt2 = DateTimeConverter.convertToLocalDateTime(dto.lastDateTime());
        return findPhysicianByLicenseNumber
        .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null
                && e.getFinishingDateTime() == null
                && (e.getScheduledDateTime().isAfter(ldt1) || e.getScheduledDateTime().isEqual(ldt1))
                && (e.getScheduledDateTime().isBefore(ldt2) || e.getScheduledDateTime().isEqual(ldt2))
            )
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(@PhysicianLicenseNumber String physicianLicenseNumber,
                                                @SSN String ssn, 
                                                @NotNull BetweenDatesTimesDTO dto
    ) {
        validateDateTimes(dto);
        LocalDateTime ldt1 = DateTimeConverter.convertToLocalDateTime(dto.firstDateTime());
        LocalDateTime ldt2 = DateTimeConverter.convertToLocalDateTime(dto.lastDateTime());
        Patient patient = findPatientBySsn.findBySsn(ssn);
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null
                && e.getFinishingDateTime() == null
                && e.getPatient().equals(patient)
                && (e.getScheduledDateTime().isAfter(ldt1) || e.getScheduledDateTime().isEqual(ldt1))
                && (e.getScheduledDateTime().isBefore(ldt2) || e.getScheduledDateTime().isEqual(ldt2))
            )
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@PhysicianLicenseNumber String physicianLicenseNumber) {
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null && e.getFinishingDateTime() == null)
            .toList();
    }

    private void validateDateTimes(BetweenDatesTimesDTO dto) {
        checkIfDateTimesAreValid.checkIfFirstDateTimeIsBeyondLastDateTime(dto);
    }
    
}
