package com.api.v1.medical_appointment.helper.find_by_physician;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.MedicalAppointmentNotFoundException;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByPhysicianImpl implements FindMedicalAppointmentByPhysician {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    
    @Override
    @Transactional(readOnly = true)
    @CachePut
    public MedicalAppointment findByPhysician(@PhysicianLicenseNumber String physicianLicenseNumber, @NotNull LocalDateTime dateTime) {
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(physicianLicenseNumber);
        Optional<MedicalAppointment> medicalAppointment = repository.findScheduledMedicalAppointmentByPhysician(physician, dateTime);
        validateInput(medicalAppointment, dateTime.toString());
        return medicalAppointment.get();
    }

    private void validateInput(Optional<MedicalAppointment> optional, String dateTime) {
        if (optional.isEmpty()) throw new MedicalAppointmentNotFoundException(dateTime);
    }
    
}
