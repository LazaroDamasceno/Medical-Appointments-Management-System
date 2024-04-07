package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find.find_by_date.FindMedicalAppointmentByDate;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddMedicalNotesService implements AddMedicalNotes {
    
    private final MedicalAppointmentRepository repository;
    private final FindMedicalAppointmentByDate findMedicalAppointmentByDate;
    
    @Override
    @Transactional
    public ResponseEntity<Void> add(@NotNull MedicalNotesDTO dto) {
        MedicalAppointment medicalAppointment = findMedicalAppointmentByDate.findByDate(dto.ssn(), dto.mln(), dto.dateTime());
        medicalAppointment.setMedicalNotes(dto.notes());
        repository.save(medicalAppointment);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
