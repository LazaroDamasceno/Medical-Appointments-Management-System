package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-notes")
@RequiredArgsConstructor
public class AddMedicalNotesController implements AddMedicalNotes {

    private final AddMedicalNotesService service;

    @Override
    @PatchMapping
    @Transactional
    public ResponseEntity<Void> add(@NotNull @RequestBody MedicalNotesDTO dto) {
        return service.add(dto);
    }
    
}
