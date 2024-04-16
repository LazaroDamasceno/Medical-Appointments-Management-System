package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.NoMedicalAppointmentFoundException;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentByPhysicianServiceImpl implements FindCanceledMedicalAppointmentByPhysicianService {

    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber) {
        List<MedicalAppointment> medicalAppointments = findPhysicianByLicenseNumber
            .findByPhysicanLicenseNumber(physicianLicenseNumber)
            .getAppointmentList();
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
