package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.HttpStatusCodes;
import com.api.v1.auxiliary.PhysicianLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class UpdatePhysicianController {
    
    private final UpdatePhysicianService service;
    
    @PutMapping("{physicianLicenseNumber}")
    @Transactional
    public ResponseEntity<Void> update(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber, @NotNull @RequestBody UpdatePhysicianDTO dto) {
        service.update(physicianLicenseNumber, dto);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
