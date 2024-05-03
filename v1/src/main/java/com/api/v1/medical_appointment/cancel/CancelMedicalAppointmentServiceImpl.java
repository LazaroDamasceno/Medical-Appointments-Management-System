package com.api.v1.medical_appointment.cancel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.DateTimeConverter;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.find_by_patient.FindMedicalAppointmentByPatient;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CancelMedicalAppointmentServiceImpl implements CancelMedicalAppointmentService {
    
    private final MedicalAppointmentRepository repository;
    private final FindMedicalAppointmentByPatient findMedicalAppointmentByPatient;

    @Override
    @Transactional
    public void cancel(@NotNull CancelMedicalAppointmentDTO dto) {
        MedicalAppointment medicalAppointment = findMedicalAppointmentByPatient.findByPatient(dto.ssn(), DateTimeConverter.convertToZonedDateTime(dto.dateTime()));
        validateInput(medicalAppointment);
        medicalAppointment.cancel();
        repository.save(medicalAppointment);
    }

    private void validateInput(MedicalAppointment medicalAppointment) {
        if (medicalAppointment.getFinishingDateTime() != null) {
            throw new FinishedMedicalAppointmentException();
        }
    }
    
}
