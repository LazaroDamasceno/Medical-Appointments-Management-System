package com.api.v1.medical_appointment.transfer;

import org.springframework.http.ResponseEntity;

public interface TransferMedicalAppointment {

    ResponseEntity<Void> transfer(TransferMedicalAppointmentDTO dto);

}
