package com.api.v1.medical_appointment.find_by.find_by_physician;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_by.MedicalAppointmentNotFoundException;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByMlnService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentByPhysicianService implements FindMedicalAppointmentByPhysician {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByMlnService findPhysicianByMln;
    
    @Override
    @Transactional
    public MedicalAppointment findByPhysician(@NotNull @Size(min = 7, max = 7) String mln, @NotNull LocalDateTime dateTime) {
        Physician physician = findPhysicianByMln.findByMln(mln);
        validateInput(physician, dateTime);
        return repository.findMedicalAppointmentByPhysician(physician, dateTime);
    }

    private void validateInput(Physician physician, LocalDateTime date) {
        if (repository.findMedicalAppointmentByPhysician(physician, date) == null) {
            throw new MedicalAppointmentNotFoundException(physician, date);
        }
    }
    
}
