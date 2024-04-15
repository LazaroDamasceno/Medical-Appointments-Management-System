package com.api.v1.medical_appointment.find_for_internal_user.find_between_dates;

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
    public List<MedicalAppointment> findAll(@NotNull BetweenDatesDTO dto) {
        return repository.findMedicalAppointmentsBeetwenDates(dto.firstDateTime(), dto.lastDateTime());
    }
    
}
