package com.api.v1.medical_appointment.find_by.find_by_patient.canceled;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPatientServiceImpl implements FindCanceledMedicalAppointmentsByPatientService {

    private final FindPatientBySsn findPatientBySsn;
    private final MedicalAppointmentRepository repository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable("canceled-medical-appointment-of-patient")
    public List<MedicalAppointment> findAll(@SSN String ssn) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        return repository.getCanceledMedicalAppointmentsByPatient(patient);
    }
    
}
