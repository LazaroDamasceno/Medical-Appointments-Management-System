package com.api.v1.medical_appointment.find_all.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/scheduled")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsController implements FindScheduledMedicalAppointments {

    private final FindScheduledMedicalAppointmentsService service;

    @Override
    @GetMapping
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> findAllScheduled() {
        return service.findAllScheduled();
    }
    
}
