package com.api.v1.physician.update;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class UpdatePhysicianController {
    
    private final UpdatePhysicianService service;
    
    @PutMapping
    public ResponseEntity<String> update(@NotNull @RequestBody UpdatePhysicianDTO dto) {
        service.update(dto);
        return ResponseEntity.status(204).body(Constants.NO_CONTENT_204);
    }
    
}
