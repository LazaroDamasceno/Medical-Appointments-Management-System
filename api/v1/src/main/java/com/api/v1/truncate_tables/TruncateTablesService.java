package com.api.v1.truncate_tables;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.PatientRepository;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.system_user.SystemUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TruncateTablesService implements TruncateTables {

    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;
    private final SystemUserRepository systemUserRepository;

    @Override
    @Transactional
    public ResponseEntity<Void> truncateTables() {
        medicalAppointmentRepository.deleteAll();
        physicianRepository.deleteAll();
        patientRepository.deleteAll();
        systemUserRepository.deleteAll();
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
