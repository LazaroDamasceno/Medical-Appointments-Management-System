package com.api.v1.medical_appointment.find_by_patient.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.NoMedicalAppointmentFoundException;
import com.api.v1.medical_appointment.internal_user.find_between_dates.FindMedicalAppointmentsBetweenDates;
import com.api.v1.patient.Patient;
import com.api.v1.patient.find_by_ssn.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPatientService implements FindFinishedMedicalAppointmentsByPatient {

    private final FindMedicalAppointmentsBetweenDates findMedicalAppointmentsBetweenDates;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull @Size(min=9, max=9) String ssn, 
                                                        @NotNull LocalDateTime firstDateTime, 
                                                        @NotNull LocalDateTime lastDateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        List<MedicalAppointment> medicalAppointments = findMedicalAppointmentsBetweenDates.findAll(firstDateTime, lastDateTime);
        noMedicalAppointmentWasFound(medicalAppointments);
        return ResponseEntity.ok(
            medicalAppointments
                .stream()
                .filter(e -> e.getFinishingDateTime() != null 
                    && e.getPatient().equals(patient)
                ).toList()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull @Size(min=9, max=9) String ssn, 
                                                                    @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
                                                                    @NotNull LocalDateTime firstDateTime, 
                                                                    @NotNull LocalDateTime lastDateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(physicianLicenseNumber);
        List<MedicalAppointment> medicalAppointments = findMedicalAppointmentsBetweenDates.findAll(firstDateTime, lastDateTime);
        noMedicalAppointmentWasFound(medicalAppointments);
        return ResponseEntity.ok(
            medicalAppointments
                .stream()
                .filter(e -> e.getFinishingDateTime() != null 
                    && e.getPatient().equals(patient)
                    && e.getPhysician().equals(physician)
                ).toList()
        );
    }

    private void noMedicalAppointmentWasFound(List<MedicalAppointment> medicalAppointments) {
        if (medicalAppointments.isEmpty()) throw new NoMedicalAppointmentFoundException();
    }
    
}
