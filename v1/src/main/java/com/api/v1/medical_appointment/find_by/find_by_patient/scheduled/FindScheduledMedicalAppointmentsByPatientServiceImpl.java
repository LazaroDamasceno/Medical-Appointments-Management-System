package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;
import com.api.v1.medical_appointment.find_by.helper.CheckIfDateTimesAreValid;
import com.api.v1.patient.Patient;
import com.api.v1.patient.helper.FindPatientBySsn;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPatientServiceImpl implements FindScheduledMedicalAppointmentsByPatientService {

    private final FindPatientBySsn findPatientBySsn;
    private final CheckIfDateTimesAreValid checkIfDateTimesAreValid;
    private final MedicalAppointmentRepository repository;
    
    @Override
    @Transactional(readOnly = true)
    public List<MedicalAppointment> find(@SSN String ssn, @NotNull BetweenDatesTimesDTO dto) {
        Patient patient = findPatientBySsn.findBySsn(ssn);
        validateDateTimes(dto);
        return repository.getScheduledMedicalAppointmentsByPatient(patient, dto.firstDateTime(), dto.lastDateTime());
    }

    private void validateDateTimes(BetweenDatesTimesDTO dto) {
        checkIfDateTimesAreValid.checkIfFirstDateTimeIsBeyondLastDateTime(dto);
    }
    
}
