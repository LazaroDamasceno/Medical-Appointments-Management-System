package com.api.v1.medical_appointment.find_by_patient.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithoutPhysicianDTO;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithPhysicianDTO;
import com.api.v1.medical_appointment.find_by_patient.NoMedicalAppointmentFoundException;
import com.api.v1.medical_appointment.find_for_internal_user.find_between_dates.FindMedicalAppointmentsBetweenDates;
import com.api.v1.patient.Patient;
import com.api.v1.patient.find_by_ssn.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentService implements FindScheduledMedicalAppointment {

    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    private final FindMedicalAppointmentsBetweenDates findMedicalAppointmentsBetweenDates;
    
    @Override
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull MedicalAppointmentInputWithoutPhysicianDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        List<MedicalAppointment> medicalAppointments = findMedicalAppointmentsBetweenDates.findAll(dto.betweenDatesDTO());
        validateInput(medicalAppointments);
        return ResponseEntity.ok(
            medicalAppointments
                .stream()
                .filter(e -> e.getPatient().equals(patient))
                .toList()
        );
    }

    @Override
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull MedicalAppointmentInputWithPhysicianDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(dto.physicianLicenseNumber());
        List<MedicalAppointment> medicalAppointments = findMedicalAppointmentsBetweenDates.findAll(dto.betweenDatesDTO());
        validateInput(medicalAppointments);
        return ResponseEntity.ok(
            medicalAppointments
                .stream()
                .filter(e -> e.getPatient().equals(patient) && e.getPhysician().equals(physician))
                .toList()
        );
    }

    private void validateInput(List<MedicalAppointment> list) {
        if (list.isEmpty()) throw new NoMedicalAppointmentFoundException();
    }
    
}
