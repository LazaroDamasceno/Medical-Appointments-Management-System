package com.api.v1.medical_appointment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_medical_appointment")
@Getter
@Setter
@NoArgsConstructor
public class MedicalAppointment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date scheduledDateTime;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime cancelationDateTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "physician_id")
	private Physician physician;

}
