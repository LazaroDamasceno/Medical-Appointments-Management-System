package com.api.v1.medical_record.create_or_add;

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
    public class MedicalRecordCreateOrAddService implements MedicalRecordCreateOrAdd {
        
        private final MedicalRecordRepository repository;
        
    @Override
    @Transactional
    public void createOrAdd(Physician physician, Patient patient, MedicalAppointment medicalAppointment) {
        Optional<MedicalRecord> optional = repository.findByPatient(patient);
        if (optional.isPresent()) add(patient, medicalAppointment);
        else createAndAdd(physician, patient, medicalAppointment);
    }

    private void add(Patient patient, MedicalAppointment medicalAppointment) {
        MedicalRecord medicalRecord = repository.findByPatient(patient).get();
        medicalRecord.addMedicalappointment(medicalAppointment);
        repository.save(medicalRecord);
    }

    private void createAndAdd(Physician physician, Patient patient, MedicalAppointment medicalAppointment) {
        MedicalRecord medicalRecord = new MedicalRecord(physician, patient);
        medicalRecord.addMedicalappointment(medicalAppointment);
        repository.save(medicalRecord);
    }
    
}