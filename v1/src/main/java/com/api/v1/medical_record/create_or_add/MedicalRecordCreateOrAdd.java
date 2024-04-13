package com.api.v1.medical_record.create_or_add;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

public interface MedicalRecordCreateOrAdd {
    
    void createOrAdd(Physician physician, Patient patient, MedicalAppointment medicalAppointment);

}
