package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class UpdatePhysicianController implements UpdatePhysician  {
    
    private final UpdatePhysicianService service;
    
    @Override
    @PutMapping
    @Transactional
    public ResponseEntity<Void> update(@NotNull @RequestBody UpdatePhysicianDTO dto) {
        return service.update(dto);
    }
    
}
