package com.api.v1.medical_appointment.transfer;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.auxiliary.DateTimeConverter;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.internal_user.find_by_physician.FindMedicalAppointmentByPhysician;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.api.v1.physician.internal_use.FindPhysicianByLicenseNumber;

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
        Physician physician = findPhysicianByLicenseNumber.findByphysicianLicenseNumber(dto.physicianLicenseNumber());
        validateDates(dto.oldMedicalAppointmentDate(), dto.newMedicalAppointmentDate());
        MedicalAppointment oldMedicalAppointment = findMedicalAppointmentByPhysician.findByPhysician(
            dto.physicianLicenseNumber(), 
            DateTimeConverter.convert(dto.newMedicalAppointmentDate())
        );
        Patient patient = oldMedicalAppointment.getPatient();
        System.out.println(patient);
        oldMedicalAppointment.cancel();
        repository.save(oldMedicalAppointment);
        MedicalAppointment newMedicalAppointment = new MedicalAppointment(dto.newMedicalAppointmentDate(), patient, physician);
        repository.save(newMedicalAppointment);
    }   

    private LocalDateTime oldDateTime;
    private LocalDateTime newDateTime; 

    private void validateDates (String oldDateTime, String newDateTime) {
        this.oldDateTime = DateTimeConverter.convert(oldDateTime);
        this.newDateTime = DateTimeConverter.convert(newDateTime);  
        if (this.oldDateTime.isAfter(this.newDateTime)) throw new OldScheduledDateTimeException();
        if (this.newDateTime.isBefore(this.oldDateTime) || this.newDateTime.isEqual(this.oldDateTime)) {
            throw new NewScheduledDateTimeException();
        }
    }
}
