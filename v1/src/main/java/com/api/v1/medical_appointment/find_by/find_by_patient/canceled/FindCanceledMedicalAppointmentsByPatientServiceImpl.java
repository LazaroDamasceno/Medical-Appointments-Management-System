package com.api.v1.medical_appointment.find_by.find_by_patient.canceled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.patient.internal_use.FindPatientBySsn;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPatientServiceImpl implements FindCanceledMedicalAppointmentsByPatientService {

    private final FindPatientBySsn findPatientBySsn;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@NotNull @Size(min=9, max=9) String ssn, 
                                                            @NotNull LocalDateTime firstDateTime, 
                                                            @NotNull LocalDateTime lastDateTime
    ) {
        return findPatientBySsn
            .findBySsn(ssn)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() != null)
            .toList();
    }
    
}
