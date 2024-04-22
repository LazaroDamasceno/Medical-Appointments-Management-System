package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindCanceledMedicalAppointmentsByPhysicianService {

    List<MedicalAppointment> find(@PhysicianLicenseNumber String physicianLicenseNumber);
    
}
