package com.api.v1.medical_record;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_medical_record")
@Getter
@Setter
@NoArgsConstructor
public class MedicalRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physician_id")
    private Physician Physician;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<MedicalAppointment> appointmentList = new ArrayList<>();

    public MedicalRecord(Physician physician, Patient patient) {
        Physician = physician;
        this.patient = patient;
    }

    public void addMedicalappointment(MedicalAppointment medicalAppointment) {
        this.appointmentList.add(medicalAppointment);
    }
 
}
