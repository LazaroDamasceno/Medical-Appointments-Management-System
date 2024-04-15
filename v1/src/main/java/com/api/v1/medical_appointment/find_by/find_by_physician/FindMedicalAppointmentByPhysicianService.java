package com.api.v1.medical_appointment.find_by.find_by_physician;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_by.MedicalAppointmentNotFoundException;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByLicenseNumberService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByPhysicianService implements FindMedicalAppointmentByPhysician {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByLicenseNumberService findPhysicianByLicenseNumber;
    
    @Override
    @Transactional(readOnly = true)
    public MedicalAppointment findByPhysician(@NotNull @Size(min = 7, max = 7) String physicanLicenseNumber, @NotNull LocalDateTime dateTime) {
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(physicanLicenseNumber);
        validateInput(physician, dateTime);
        return repository.findScheduledMedicalAppointmentByPhysician(physician, dateTime);
    }

    private void validateInput(Physician physician, LocalDateTime date) {
        if (repository.findScheduledMedicalAppointmentByPhysician(physician, date) == null) {
            throw new MedicalAppointmentNotFoundException(physician, date);
        }
    }
    
}
