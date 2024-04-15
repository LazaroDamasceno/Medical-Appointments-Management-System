package com.api.v1.medical_appointment.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.internal_user.find_by_physician.FindMedicalAppointmentByPhysician;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByLicenseNumber;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferMedicalAppointmentService implements TransferMedicalAppointment {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByLicenseNumber findPhysicianByLicenseNumber;
    private final FindMedicalAppointmentByPhysician findMedicalAppointmentByPhysician;
    
    @Override
    @Transactional
    public ResponseEntity<Void> transfer(TransferMedicalAppointmentDTO dto) {
        Physician physician = findPhysicianByLicenseNumber.findByPhysicanLicenseNumber(dto.physicanLicenseNumber());
        MedicalAppointment oldMedicalAppointment = findMedicalAppointmentByPhysician.findByPhysician(dto.physicanLicenseNumber(), dto.oldMedicalAppointmentDate());
        Patient patient = oldMedicalAppointment.getPatient();
        System.out.println(patient);
        oldMedicalAppointment.cancel();
        repository.save(oldMedicalAppointment);
        MedicalAppointment newMedicalAppointment = new MedicalAppointment(dto.newMedicalAppointmentDate(), patient, physician);
        repository.save(newMedicalAppointment);
        return HttpStatusCodes.CREATED_201;
    }
    
}
