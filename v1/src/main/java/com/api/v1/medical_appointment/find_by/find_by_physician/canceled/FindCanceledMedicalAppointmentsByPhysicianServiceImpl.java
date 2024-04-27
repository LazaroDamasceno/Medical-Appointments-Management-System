package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPhysicianServiceImpl implements FindCanceledMedicalAppointmentsByPhysicianService {

    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@PhysicianLicenseNumber String physicianLicenseNumber) {
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() != null)
            .toList();
    }
    
}
