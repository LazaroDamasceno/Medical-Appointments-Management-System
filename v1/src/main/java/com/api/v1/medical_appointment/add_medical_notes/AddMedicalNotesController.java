package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-notes")
@RequiredArgsConstructor
public class AddMedicalNotesController {

    private final AddMedicalNotesService service;

    @PatchMapping("{ssn}/{physicianLicenseNumber}/dateTime")
    public ResponseEntity<String> add(@NotNull @RequestBody MedicalNotesDTO dto) {
        service.add(dto);
        String message = "Medical appointment's medical notes whose scheduled date time is %s were added.".formatted(dto.dateTime());
        return ResponseEntity.status(204).body(message);
    }
    
}
