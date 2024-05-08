package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/scheduled/by-physician")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPhysicianController {

    private final FindScheduledMedicalAppointmentsByPhysicianService service;

    @Transactional(readOnly = true)
    @GetMapping("{physicianLicenseNumber}")
    public List<MedicalAppointment> find(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
                                                        @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return service.find(physicianLicenseNumber, dto);
    }
    
}
