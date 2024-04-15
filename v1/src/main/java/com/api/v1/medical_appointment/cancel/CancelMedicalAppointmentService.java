package com.api.v1.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_for_internal_user.find_by_patient.FindMedicalAppointmentByPatient;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CancelMedicalAppointmentService implements CancelMedicalAppointment {
    
    private final MedicalAppointmentRepository repository;
    private final FindMedicalAppointmentByPatient findMedicalAppointmentByPatient;

    @Override
    @Transactional
    public ResponseEntity<Void> cancel(@NotNull CancelMedicalAppointmentDTO dto) {
        MedicalAppointment medicalAppointment = findMedicalAppointmentByPatient.findByPatient(dto.ssn(), dto.dateTime());
        validateInput(medicalAppointment);
        medicalAppointment.cancel();
        repository.save(medicalAppointment);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private void validateInput(MedicalAppointment medicalAppointment) {
        if (medicalAppointment.getFinishingDateTime() != null) {
            throw new FinishedMedicalAppointmentException();
        }
    }
    
}
