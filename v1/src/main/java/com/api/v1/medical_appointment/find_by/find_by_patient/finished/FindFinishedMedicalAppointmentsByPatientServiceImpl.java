package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.auxiliary.DateTimeConverter;
import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPatientServiceImpl implements FindFinishedMedicalAppointmentsByPatientService {

    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@SSN String ssn, 
                                            @NotNull String firstDateTime, 
                                            @NotNull String lastDateTime
    ) {
        LocalDateTime ldt1 = DateTimeConverter.convert(firstDateTime);
        LocalDateTime ldt2 = DateTimeConverter.convert(lastDateTime);
        return findPatientBySsn.
            findBySsn(ssn)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
                && (e.getScheduledDateTime().isAfter(ldt1) || e.getScheduledDateTime().isEqual(ldt1))
                && (e.getScheduledDateTime().isBefore(ldt2) || e.getScheduledDateTime().isEqual(ldt2))
            ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                                    @PhysicianLicenseNumber String physicianLicenseNumber,
                                                    @NotNull String firstDateTime, 
                                                    @NotNull String lastDateTime
    ) {
        LocalDateTime ldt1 = DateTimeConverter.convert(firstDateTime);
        LocalDateTime ldt2 = DateTimeConverter.convert(lastDateTime);
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        return findPatientBySsn.
            findBySsn(ssn)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
            && (e.getScheduledDateTime().isAfter(ldt1) || e.getScheduledDateTime().isEqual(ldt1))
            && (e.getScheduledDateTime().isBefore(ldt2) || e.getScheduledDateTime().isEqual(ldt2))
                && e.getPhysician().equals(physician)
            ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@SSN String ssn) {
        return findPatientBySsn.
            findBySsn(ssn)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getFinishingDateTime() != null)
            .toList();
    }
    
}
