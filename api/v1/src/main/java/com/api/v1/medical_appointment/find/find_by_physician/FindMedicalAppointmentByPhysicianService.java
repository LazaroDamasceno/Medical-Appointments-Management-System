package com.api.v1.medical_appointment.find.find_by_physician;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find.MedicalAppointmentNotFoundException;
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
    public MedicalAppointment findByPhysician(@NotNull @Size(min = 7, max = 7) String ssn, @NotNull Date dateTime) {
        Physician physician = findPhysicianByMln.findByMln(ssn);
        validateInput(physician, dateTime);
        return repository.findMedicalAppointmentByPhysician(null, dateTime);
    }

    private void validateInput(Physician physician, Date date) {
        if (repository.findMedicalAppointmentByPhysician(physician, date) == null) {
            throw new MedicalAppointmentNotFoundException(physician, date);
        }
    }
    
}
