package com.api.v1.medical_appointment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Table(name = "v1_medical_appointment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MedicalAppointment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime scheduledDateTime;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime cancelationDateTime;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime finishingDateTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	@JsonBackReference
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "physician_id")
	@JsonBackReference
	private Physician physician;

	private String medicalNotes = "";

	public MedicalAppointment(LocalDateTime scheduledDateTime, Patient patient, Physician physician) {
		this.scheduledDateTime = scheduledDateTime;
		this.patient = patient;
		this.physician = physician;
	}

	public void cancel() {
		this.cancelationDateTime = LocalDateTime.now();
	}

	public void finish() {
		this.finishingDateTime = LocalDateTime.now();
	}

	public void addMedicalNotes(@NotBlank String notes) {
		this.medicalNotes = notes;
	}

}
