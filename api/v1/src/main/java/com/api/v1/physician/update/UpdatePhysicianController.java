package com.api.v1.physician.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/physician")
@RequiredArgsConstructor
public class UpdatePhysicianController implements UpdatePhysician {

    private final UpdatePhysicianService service;

    @Override
    @Transactional
    @PutMapping("{mln}")
    public ResponseEntity<Void> update(
        @NotNull @Size(min = 7, max = 7) @PathVariable String mln, 
        @NotNull @RequestBody UpdatedSystemUserDTO dto
    ) {
        return service.update(mln, dto);
    }
    
}
