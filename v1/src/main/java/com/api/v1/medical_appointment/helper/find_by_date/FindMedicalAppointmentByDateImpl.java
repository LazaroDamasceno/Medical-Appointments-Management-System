package com.api.v1.medical_appointment.helper.find_by_date;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.MedicalAppointmentNotFoundException;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByDateImpl implements FindMedicalAppointmentByDate {

    private final MedicalAppointmentRepository repository;
    private final FindPatientBySsn findPatientBySsn;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;

    @Override
    @Transactional(readOnly = true)
    public MedicalAppointment findByDate(
        @SSN String ssn, 
        @NotNull @PhysicianLicenseNumber String physicianLicenseNumber, 
        @NotNull ZonedDateTime dateTime
    ) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        Optional<MedicalAppointment> medicalAppointment = repository.findScheduledMedicalAppointmentByDate(patient, physician, dateTime);
        validateInput(medicalAppointment, dateTime.toString());
        return medicalAppointment.get();
    }

    private void validateInput(Optional<MedicalAppointment> optional, String dateTime) {
        if (optional.isEmpty()) throw new MedicalAppointmentNotFoundException(dateTime);
    }
    
}
