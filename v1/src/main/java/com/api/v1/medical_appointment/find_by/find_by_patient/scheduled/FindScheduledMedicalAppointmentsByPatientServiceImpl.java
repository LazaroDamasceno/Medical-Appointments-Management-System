package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;
import com.api.v1.medical_appointment.find_by.helper.CheckIfDateTimesAreValid;
import com.api.v1.patient.helper.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPatientServiceImpl implements FindScheduledMedicalAppointmentsByPatientService {

    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    private final CheckIfDateTimesAreValid checkIfDateTimesAreValid;
    
    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@SSN String ssn, @NotNull BetweenDatesTimesDTO dto) {
        validateDateTimes(dto);
        return findPatientBySsn
            .findBySsn(ssn)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null
                && e.getFinishingDateTime() == null 
                && (e.getScheduledDateTime().isAfter(dto.firstDateTime()) || e.getScheduledDateTime().isEqual(dto.firstDateTime()))
                && (e.getScheduledDateTime().isBefore(dto.lastDateTime()) || e.getScheduledDateTime().isEqual(dto.lastDateTime()))
            ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                                    @PhysicianLicenseNumber String physicianLicenseNumber,
                                                    @NotNull BetweenDatesTimesDTO dto
    ) {
        validateDateTimes(dto);

        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        return findPatientBySsn
            .findBySsn(ssn)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() == null
                && e.getFinishingDateTime() == null 
                && e.getPhysician().equals(physician)
                && (e.getScheduledDateTime().isAfter(dto.firstDateTime()) || e.getScheduledDateTime().isEqual(dto.firstDateTime()))
                && (e.getScheduledDateTime().isBefore(dto.lastDateTime()) || e.getScheduledDateTime().isEqual(dto.lastDateTime()))
            ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@SSN String ssn) {
        return findPatientBySsn
        .findBySsn(ssn)
        .getAppointmentList()
        .stream()
        .filter(e -> e.getCancelationDateTime() == null && e.getFinishingDateTime() == null)
        .toList();
    }

    private void validateDateTimes(BetweenDatesTimesDTO dto) {
        checkIfDateTimesAreValid.checkIfFirstDateTimeIsBeyondLastDateTime(dto);
    }
    
}
