package com.api.v1.medical_appointment.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.v1.constants.HttpStatusCodes;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.MedicalAppointmentRepository;
import com.api.v1.medical_appointment.find_by.find_by_physician.FindMedicalAppointmentByPhysician;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.api.v1.physician.find_by_mln.FindPhysicianByMln;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferMedicalAppointmentService implements TransferMedicalAppointment {
    
    private final MedicalAppointmentRepository repository;
    private final FindPhysicianByMln findPhysicianByMln;
    private final FindMedicalAppointmentByPhysician findMedicalAppointmentByPhysician;
    
    @Override
    public ResponseEntity<Void> transfer(TransferMedicalAppointmentDTO dto) {
        Physician physician = findPhysicianByMln.findByMln(dto.mln());
        MedicalAppointment oldMedicalAppointment = findMedicalAppointmentByPhysician.findByPhysician(dto.mln(), dto.newMedicalAppointmentDate());
        Patient patient = oldMedicalAppointment.getPatient();
        oldMedicalAppointment.cancel();
        repository.save(oldMedicalAppointment);
        MedicalAppointment newMedicalAppointment = new MedicalAppointment(dto.newMedicalAppointmentDate(), patient, physician);
        repository.save(newMedicalAppointment);
        return HttpStatusCodes.CREATED_201;
    }
    
}
