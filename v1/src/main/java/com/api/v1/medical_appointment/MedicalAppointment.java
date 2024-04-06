package com.api.v1.medical_appointment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_medical_appointment")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MedicalAppointment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private LocalDateTime scheduledDateTime;
	
	private LocalDateTime cancelationDateTime;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "physician_id")
	private Physician physician;

}
