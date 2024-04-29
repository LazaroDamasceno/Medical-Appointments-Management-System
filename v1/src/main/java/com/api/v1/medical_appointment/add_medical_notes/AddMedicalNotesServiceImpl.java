package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.DateTimeConverter;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.find_by_date.FindMedicalAppointmentByDate;
import com.api.v1.medical_record.internal_usr.MedicalRecordCreateOrAdd;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class AddMedicalNotesServiceImpl implements AddMedicalNotesService {
    
    private final MedicalAppointmentRepository repository;
    private final FindMedicalAppointmentByDate findMedicalAppointmentByDate;
    private final MedicalRecordCreateOrAdd medicalRecordCreateOrAdd;
    
    @Override
    @Transactional
    public void add(@NotNull MedicalNotesDTO dto) {
        MedicalAppointment medicalAppointment = findMedicalAppointmentByDate.findByDate(dto.ssn(), dto.physicianLicenseNumber(), DateTimeConverter.convertToZonedDateTime(dto.dateTime()));
        validateInput(medicalAppointment);
        medicalAppointment.addMedicalNotes(dto.notes());
        medicalAppointment.finish();
        repository.save(medicalAppointment);
        medicalRecordCreateOrAdd.createOrAdd(medicalAppointment.getPhysician(), medicalAppointment.getPatient(), medicalAppointment);
    }

    private void validateInput(MedicalAppointment medicalAppointment) {
        if (medicalAppointment.getCancelationDateTime() != null) {
            throw new CanceledMedicalAppointmentException();
        }
    }
    
}
