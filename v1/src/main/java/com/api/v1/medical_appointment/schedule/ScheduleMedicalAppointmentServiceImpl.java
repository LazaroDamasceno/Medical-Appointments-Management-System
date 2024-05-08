package com.api.v1.medical_appointment.schedule;

import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentServiceImpl implements ScheduleMedicalAppointmentService {
    
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional
    @CachePut
    public void schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(dto.physicianLicenseNumber());
        validateInput(patient, physician, dto.dateTime());
        MedicalAppointment medicalAppointment = new MedicalAppointment(dto.dateTime(), patient, physician);
        medicalAppointmentRepository.save(medicalAppointment);
    }

    private void validateInput(Patient patient, Physician physician, LocalDateTime dateTime) {
        Optional<MedicalAppointment> medicalAppointment = medicalAppointmentRepository.findScheduledMedicalAppointmentByDate(patient, physician, dateTime);
        boolean isMedicalAppointmentScheduled = medicalAppointment.isPresent() && medicalAppointment.get().getCanceledDateTime() == null;
        if (isMedicalAppointmentScheduled) throw new DuplicatedMedicalAppointmentException();
    }
    
}
