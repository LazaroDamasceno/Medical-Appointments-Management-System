package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_by.find_by_date.FindMedicalAppointmentByDate;
import com.api.v1.medical_record.create_or_add.MedicalRecordCreateOrAdd;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddMedicalNotesService implements AddMedicalNotes {
    
    private final MedicalAppointmentRepository repository;
    private final FindMedicalAppointmentByDate findMedicalAppointmentByDate;
    private final MedicalRecordCreateOrAdd medicalRecordCreateOrAdd;
    
    @Override
    @Transactional
    public ResponseEntity<Void> add(@NotNull MedicalNotesDTO dto) {
        MedicalAppointment medicalAppointment = findMedicalAppointmentByDate.findByDate(dto.ssn(), dto.physicanLicenseNumber(), dto.dateTime());
        validateInput(medicalAppointment);
        medicalAppointment.addMedicalNotes(dto.notes());
        medicalAppointment.finish();
        repository.save(medicalAppointment);
        medicalRecordCreateOrAdd.createOrAdd(medicalAppointment.getPhysician(), medicalAppointment.getPatient(), medicalAppointment);
        return HttpStatusCodes.NO_CONTENT_204;
    }

    private void validateInput(MedicalAppointment medicalAppointment) {
        if (medicalAppointment.getCancelationDateTime() != null) {
            throw new MedicalAppointmentCancelationException();
        }
    }
    
}
