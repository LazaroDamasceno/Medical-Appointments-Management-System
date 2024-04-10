package com.api.v1.medical_appointment.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class FindMedicalAppointmentsController implements FindMedicalAppointments {

    private final FindMedicalAppointmentsService service;

    @Override
    @Transactional
    @GetMapping
    public ResponseEntity<List<MedicalAppointment>> findAll() {
        return service.findAll();
    }
    
}
