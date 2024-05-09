package com.api.v1.medical_appointment.find.canceled;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Transactional(readOnly = true)
    @GetMapping("by-patient/{ssn}")
    List<MedicalAppointment> findByPatient(@SSN String ssn) {
        return service.findByPatient(ssn);
    }

    @Transactional(readOnly = true)
    @GetMapping("by-physician/{physicianLicenseNumber}")
    List<MedicalAppointment> findByPhysician(@PhysicianLicenseNumber String physicianLicenseNumber) {
        return service.findByPatient(physicianLicenseNumber);
    }
    
}
