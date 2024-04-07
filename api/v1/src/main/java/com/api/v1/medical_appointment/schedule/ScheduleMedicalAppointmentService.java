package com.api.v1.medical_appointment.schedule;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.patient.Patient;
import com.api.v1.patient.find_by_ssn.FindPatientBySsnService;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByMlnService;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentService implements ScheduleMedicalAppointment {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsnService findPatientBySsn;
    private final FindPhysicianByMlnService findPhysicianByMln;
    
    @Override
    public ResponseEntity<Void> schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(dto.ssn());
        Physician physician = findPhysicianByMln.findByMln(dto.mln());
        validateInput(patient, physician, dto.dateTime());
        MedicalAppointment medicalAppointment = new MedicalAppointment(dto.dateTime(), patient, physician);
        repository.save(medicalAppointment);
        return HttpStatusCodes.CREATED_201;
    }

    private void validateInput(Patient patient, Physician physician, Date dateTime) {
        MedicalAppointment medicalAppointment = repository.findMedicalAppointmentByDate(patient, physician, dateTime);
        if (medicalAppointment.getCancelationDateTime() == null) {
            throw new DuplicatedMedicalAppointmentException(patient, physician, dateTime);
        }
    }
    
}
