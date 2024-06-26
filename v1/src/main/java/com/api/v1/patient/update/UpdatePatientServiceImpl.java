package com.api.v1.patient.update;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.patient.helper.FindPatientBySsn;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePatientServiceImpl implements UpdatePatientService {
    
    private final PatientRepository repository;
    private final FindPatientBySsn findPatientBySsn;
    
    @Override
    @Transactional
    public void update(@NotNull UpdatePatientDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        patient.update(dto);
        repository.save(patient);
    }
    
}
