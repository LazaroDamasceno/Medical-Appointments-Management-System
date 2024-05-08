package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

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
        return ResponseEntity.status(204).body(Constants.NO_CONTENT_204);
    }
    
}
