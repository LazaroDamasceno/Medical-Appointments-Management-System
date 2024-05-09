package com.api.v1.medical_appointment.find.canceled;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentServiceImpl implements FindCanceledMedicalAppointmentService {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPatient(@SSN String ssn) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        return repository.getCanceledMedicalAppointmentsByPatient(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findByPhysician(@PhysicianLicenseNumber String physicianLicenseNumber) {
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        return repository.getCanceledMedicalAppointmentsByPhysician(physician);
    }
    
}
