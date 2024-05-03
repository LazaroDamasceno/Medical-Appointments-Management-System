package com.api.v1.medical_appointment.transfer;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.DateTimeConverter;
import com.api.v1.helper.DuplicateDateTimeException;
import com.api.v1.helper.TemporalOrderException;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.helper.find_by_physician.FindMedicalAppointmentByPhysician;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.api.v1.physician.helper.FindPhysicianByLicenseNumber;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferMedicalAppointmentServiceImpl implements TransferMedicalAppointmentService {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    private final FindMedicalAppointmentByPhysician findMedicalAppointmentByPhysician;
    
    @Override
    @Transactional
    public void transfer(@NotNull TransferMedicalAppointmentDTO dto) {
        validateDateTimes(dto);
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(dto.physicianLicenseNumber());
        MedicalAppointment oldMedicalAppointment = findMedicalAppointmentByPhysician.findByPhysician(
            dto.physicianLicenseNumber(), 
            DateTimeConverter.convertToZonedDateTime(dto.oldMedicalAppointmentDate())
        );
        Patient patient = oldMedicalAppointment.getPatient();
        oldMedicalAppointment.cancel();
        repository.save(oldMedicalAppointment);
        MedicalAppointment newMedicalAppointment = new MedicalAppointment(dto.newMedicalAppointmentDate(), patient, physician);
        repository.save(newMedicalAppointment);
    }

    private void validateDateTimes(TransferMedicalAppointmentDTO dto) {
        ZonedDateTime firstDateTime = DateTimeConverter.convertToZonedDateTime(dto.oldMedicalAppointmentDate());
        ZonedDateTime lastDateTime = DateTimeConverter.convertToZonedDateTime(dto.newMedicalAppointmentDate());
        if (firstDateTime.isEqual(lastDateTime)) throw new DuplicateDateTimeException();
        else if (firstDateTime.isAfter(lastDateTime)) throw new TemporalOrderException();
    }
    
}
