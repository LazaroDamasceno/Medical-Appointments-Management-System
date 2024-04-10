package com.api.v1.medical_appointment.find_all.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/finished")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsController implements FindFinishedMedicalAppointments {

    private final FindFinishedMedicalAppointmentsService service;

    @Override
    @Transactional
    @GetMapping
    public ResponseEntity<List<MedicalAppointment>> findAllFinished() {
        return service.findAllFinished();
    }
    
}
