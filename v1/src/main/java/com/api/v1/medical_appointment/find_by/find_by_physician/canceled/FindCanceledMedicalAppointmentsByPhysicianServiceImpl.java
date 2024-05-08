package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPhysicianServiceImpl implements FindCanceledMedicalAppointmentsByPhysicianService {

    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional(readOnly = true)
    @Cacheable
    public List<MedicalAppointment> find(@PhysicianLicenseNumber String physicianLicenseNumber) {
        return findPhysicianByLicenseNumber
            .findByphysicianLicenseNumber(physicianLicenseNumber)
            .getAppointmentList()
            .stream()
            .filter(e -> e.getCancelationDateTime() != null)
            .toList();
    }
    
}
