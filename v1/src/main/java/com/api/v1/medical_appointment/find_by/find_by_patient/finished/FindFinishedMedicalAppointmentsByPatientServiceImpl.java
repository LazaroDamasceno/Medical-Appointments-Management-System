package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.NoMedicalAppointmentFoundException;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPatientServiceImpl implements FindFinishedMedicalAppointmentsByPatientService {

    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@NotNull @Size(min=9, max=9) String ssn, 
                                        @NotNull LocalDateTime firstDateTime, 
                                        @NotNull LocalDateTime lastDateTime
    ) {
        List<MedicalAppointment> medicalAppointments = findPatientBySsn.findBySsn(ssn).getAppointmentList();
        validateInput(medicalAppointments);
        return medicalAppointments
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
                && (e.getScheduledDateTime().isAfter(firstDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
                && (e.getScheduledDateTime().isBefore(lastDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
            ).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPhysician(@NotNull @Size(min=9, max=9) String ssn, 
                                                    @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
                                                    @NotNull LocalDateTime firstDateTime, 
                                                    @NotNull LocalDateTime lastDateTime
    ) {
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(physicianLicenseNumber);
        List<MedicalAppointment> medicalAppointments = findPatientBySsn.findBySsn(ssn).getAppointmentList();
        validateInput(medicalAppointments);
        return medicalAppointments
            .stream()
            .filter(e -> e.getFinishingDateTime() != null
            && (e.getScheduledDateTime().isAfter(firstDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
            && (e.getScheduledDateTime().isBefore(lastDateTime) || e.getScheduledDateTime().isEqual(firstDateTime))
                && e.getPhysician().equals(physician)
            ).toList();
    }

    private void validateInput(List<MedicalAppointment> list) {
        if (list.isEmpty()) throw new NoMedicalAppointmentFoundException();
    }
    
}
