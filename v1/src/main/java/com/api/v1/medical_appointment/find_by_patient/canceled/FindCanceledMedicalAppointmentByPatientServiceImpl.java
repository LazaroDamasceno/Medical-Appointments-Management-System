package com.api.v1.medical_appointment.find_by_patient.canceled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.NoMedicalAppointmentFoundException;
import com.api.v1.patient.internal_use.FindPatientBySsn;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentByPatientServiceImpl implements FindCanceledMedicalAppointmentByPatientService {

    private final FindPatientBySsn findPatientBySsn;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@NotNull @Size(min=9, max=9) String ssn, 
                                                            @NotNull LocalDateTime firstDateTime, 
                                                            @NotNull LocalDateTime lastDateTime
    ) {
        List<MedicalAppointment> medicalAppointments = findPatientBySsn.findBySsn(ssn).getAppointmentList();
        validateInput(medicalAppointments);
        return medicalAppointments
            .stream()
            .filter(e -> e.getCancelationDateTime() != null)
            .toList();
    }

    private void validateInput(List<MedicalAppointment> medicalAppointments) {
        if (medicalAppointments.isEmpty()) throw new NoMedicalAppointmentFoundException();
    }
    
}
