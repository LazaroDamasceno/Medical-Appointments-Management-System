package com.api.v1.drop_tables;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.AsyncHttpStatus;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.PatientRepository;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.system_user.SystemUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DropTablesService implements DropTables {

    private final PatientRepository patientRepository;
    private final PhysicianRepository physicianRepository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final SystemUserRepository systemUserRepository;

    @Override
    public CompletableFuture<ResponseEntity<Void>> dropTables() {
        medicalAppointmentRepository.dropTable();
        patientRepository.dropTable();
        physicianRepository.dropTable();
        systemUserRepository.dropTable();
        return AsyncHttpStatus.NO_CONTENT_204;
    }
    
}
