package com.api.v1.medical_appointment.schedule;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;
import com.api.v1.patient.find_by_ssn.FindPatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.PhysicianRepository;
import com.api.v1.physician.find_by_mln.FindPhysicianByMlnService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentService implements ScheduleMedicalAppointment {
    
    private final PhysicianRepository physicianRepository;
    private final PatientRepository patientRepository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final FindPatientBySsnService findPatientBySsn;
    private final FindPhysicianByMlnService findPhysicianByMln;
    
    @Override
    @Transactional
    public ResponseEntity<Void> schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        Physician physician = findPhysicianByMln.findByMln(dto.mln());
        validateInput(patient, physician, dto.dateTime());
        MedicalAppointment medicalAppointment = new MedicalAppointment(dto.dateTime(), patient, physician);
        medicalAppointmentRepository.save(medicalAppointment);
        patient.addMedicalAppointment(medicalAppointment);
        patientRepository.save(patient);
        physician.addMedicalAppointment(medicalAppointment);
        physicianRepository.save(physician);
        return HttpStatusCodes.CREATED_201;
    }

    private void validateInput(Patient patient, Physician physician, Date dateTime) {
        if (medicalAppointmentRepository.findMedicalAppointmentByDate(patient, physician, dateTime) == null) {
            throw new DuplicatedMedicalAppointmentException(patient, physician, dateTime);
        }
    }
    
}
