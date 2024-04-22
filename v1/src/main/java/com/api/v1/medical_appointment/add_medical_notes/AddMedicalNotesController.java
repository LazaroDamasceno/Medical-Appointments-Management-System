package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.HttpStatusCodes;
import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-notes")
@RequiredArgsConstructor
public class AddMedicalNotesController {

    private final AddMedicalNotesService service;

    @PatchMapping("{ssn}/{physicianLicenseNumber}/dateTime")
    @Transactional
    public ResponseEntity<Void> add(@SSN @PathVariable String ssn, 
                                    @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber, 
                                    @NotNull @PathVariable String dateTime, 
                                    @NotNull @RequestBody MedicalNotesDTO dto
    ) {
        service.add(ssn, physicianLicenseNumber, dateTime, dto);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
