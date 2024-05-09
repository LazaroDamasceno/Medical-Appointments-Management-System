package com.api.v1.medical_appointment.find.canceled;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment/canceled")
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentController {

    private final FindCanceledMedicalAppointmentService service;

    @GetMapping("by-patient/{ssn}")
    public List<MedicalAppointment> findByPatient(@SSN @PathVariable String ssn) {
        return service.findByPatient(ssn);
    }

    @GetMapping("by-physician/{physicianLicenseNumber}")
    public List<MedicalAppointment> findByPhysician(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber) {
        return service.findByPatient(physicianLicenseNumber);
    }
    
}
