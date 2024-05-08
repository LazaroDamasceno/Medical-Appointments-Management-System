package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

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
@RequestMapping("api/v1/medical-appointments/scheduled/by-patient")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPatientController {

    private final FindScheduledMedicalAppointmentsByPatientService service;

    @GetMapping("{ssn}")
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@SSN @PathVariable String ssn, @NotNull @RequestBody BetweenDatesTimesDTO dto) {
        return service.find(ssn, dto);
    }

    @Transactional(readOnly = true)
    @GetMapping("and-by-physician/{ssn}/{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    public List<MedicalAppointment> findByPhysician(@SSN @PathVariable String ssn,
                                                                    @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
                                                                    @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return service.findByPhysician(ssn, physicianLicenseNumber, dto);
    }

    @GetMapping("ssn/{ssn}")
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@SSN @PathVariable String ssn) {
        return service.findAll(ssn);
    }
    
}
