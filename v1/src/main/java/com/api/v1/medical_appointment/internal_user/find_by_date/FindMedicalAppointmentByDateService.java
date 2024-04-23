package com.api.v1.medical_appointment.internal_user.find_by_date;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.internal_user.MedicalAppointmentNotFoundException;
import com.api.v1.patient.Patient;
import com.api.v1.patient.internal_use.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByDateService implements FindMedicalAppointmentByDate {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public MedicalAppointment findByDate(
        @SSN String ssn, 
        @NotNull @PhysicianLicenseNumber String physicianLicenseNumber, 
        @NotNull LocalDateTime dateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        Optional<MedicalAppointment> medicalAppointment = repository.findScheduledMedicalAppointmentByDate(patient, physician, dateTime);
        validateInput(medicalAppointment);
        return medicalAppointment.get();
    }

    private void validateInput(Optional<MedicalAppointment> optional) {
        if (optional.isEmpty()) throw new MedicalAppointmentNotFoundException();
    }
    
}
