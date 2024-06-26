package com.api.v1.physician.update;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePhysicianServiceImpl implements UpdatePhysicianService {
    
    private final PhysicianRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional
    public void update(@NotNull UpdatePhysicianDTO dto) {
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(dto.physicianLicenseNumber());
        physician.update(dto);
        repository.save(physician);
        
    }
    
}
