package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/finished/by-physician")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPhysicianController {

    private final FindFinishedMedicalAppointmentsByPhysicianService service;

    @GetMapping("{physicianLicenseNumber}")
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(
            @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
            @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return service.find(physicianLicenseNumber, dto);
    }

    @GetMapping("{physicianLicenseNumber}/{ssn}")
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(
            @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber, 
            @SSN @PathVariable String ssn,
            @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return service.findByPatient(physicianLicenseNumber, ssn, dto);
    }

    @GetMapping("license-number/{physicianLicenseNumber}")
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber) {
        return service.findAll(physicianLicenseNumber);
    }
    
}
