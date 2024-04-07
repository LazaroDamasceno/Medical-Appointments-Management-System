package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.system_user.UpdatedSystemUserDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class UpdatePhysicianController implements UpdatePhysician {

    private final UpdatePhysicianService service;

    @Override
    @Transactional
    @PutMapping
    public ResponseEntity<Void> update(@NotNull @RequestBody UpdatedSystemUserDTO dto) {
        return service.update(dto);
    }
    
}
