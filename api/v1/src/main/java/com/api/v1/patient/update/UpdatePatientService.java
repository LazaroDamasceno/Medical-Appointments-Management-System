package com.api.v1.patient.update;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.patient.find_by_ssn.FindPatientBySsn;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePatientService implements UpdatePatient {
    
    private final PatientRepository repository;
    private final FindPatientBySsn findPatientBySsn;
    
    @Override
    @Transactional
    public ResponseEntity<Void> update(@NotNull @Size(min=9, max=9) String ssn, @NotNull UpdatePatientDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        patient.update(dto);
        repository.save(patient);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
