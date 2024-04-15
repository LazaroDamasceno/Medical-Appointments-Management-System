package com.api.v1.medical_appointment.internal_user.find_between_dates;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindMedicalAppointmentsBetweenDatesService implements FindMedicalAppointmentsBetweenDates {

    private final MedicalAppointmentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> findAll(@NotNull LocalDateTime firstDateTime, @NotNull LocalDateTime lastDateTime) {
        return repository.findMedicalAppointmentsBeetwenDates(firstDateTime, lastDateTime);
    }
    
}
