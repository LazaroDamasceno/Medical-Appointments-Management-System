package com.api.v1.medical_record.internal_usr;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_record.MedicalRecord;
import com.api.v1.medical_record.MedicalRecordRepository;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalRecordCreateOrAddImpl implements MedicalRecordCreateOrAdd {
        
        private final MedicalRecordRepository repository;
        
    @Override
    @Transactional
    public void createOrAdd(Physician physician, Patient patient, MedicalAppointment medicalAppointment) {
        Optional<MedicalRecord> optional = repository.findByPatient(patient);
        if (optional.isPresent()) addMedicalAppointment(patient, medicalAppointment);
        else createMedicalRecordAndAddMedicalAppointment(physician, patient, medicalAppointment);
    }

    private void addMedicalAppointment(Patient patient, MedicalAppointment medicalAppointment) {
        MedicalRecord medicalRecord = repository.findByPatient(patient).get();
        medicalRecord.addMedicalappointment(medicalAppointment);
        repository.save(medicalRecord);
    }

    private void createMedicalRecordAndAddMedicalAppointment(Physician physician, Patient patient, MedicalAppointment medicalAppointment) {
        MedicalRecord medicalRecord = new MedicalRecord(physician, patient);
        medicalRecord.addMedicalappointment(medicalAppointment);
        repository.save(medicalRecord);
    }
    
}