package com.api.v1.medical_appointment.schedule;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.patient.internal_use.FindPatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumberService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentService implements ScheduleMedicalAppointment {
    
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final FindPatientBySsnService findPatientBySsn;
    private final FindPhysicianByLicenseNumberService findPhysicianByLicenseNumber;
    
    @Override
    @Transactional
    public ResponseEntity<Void> schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(dto.physicanLicenseNumber());
        validateInput(patient, physician, dto.dateTime());
        MedicalAppointment medicalAppointment = new MedicalAppointment(dto.dateTime(), patient, physician);
        medicalAppointmentRepository.save(medicalAppointment);
        patient.addMedicalAppointment(medicalAppointment);
        patientRepository.save(patient);
        physician.addMedicalAppointment(medicalAppointment);
        physicianRepository.save(physician);
        return HttpStatusCodes.CREATED_201;
    }

    private void validateInput(Patient patient, Physician physician, LocalDateTime dateTime) {
        if (medicalAppointmentRepository.findScheduledMedicalAppointmentByDate(patient, physician, dateTime).isPresent()) {
            throw new DuplicatedMedicalAppointmentException();
        }
    }
    
}
