package com.api.v1.drop_tables;

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
public class DropTablesService implements DropTables {

    private final PatientRepository patientRepository;
    private final PhysicianRepository physicianRepository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final SystemUserRepository systemUserRepository;

    @Override
    @Transactional
    public ResponseEntity<Void> dropTables() {
        medicalAppointmentRepository.dropTable();
        patientRepository.dropTable();
        physicianRepository.dropTable();
        systemUserRepository.dropTable();
        return HttpStatusCodes.NO_CONTENT_204;
    }

}
