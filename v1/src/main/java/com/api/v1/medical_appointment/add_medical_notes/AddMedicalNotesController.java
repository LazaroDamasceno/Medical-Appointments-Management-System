package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helper.constant.HttpStatusCodes;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-notes")
@RequiredArgsConstructor
class AddMedicalNotesController {

    private final AddMedicalNotesService service;

    @PatchMapping("{ssn}/{physicianLicenseNumber}/dateTime")
    @Transactional
    public ResponseEntity<Void> add(@NotNull @RequestBody MedicalNotesDTO dto) {
        service.add(dto);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
