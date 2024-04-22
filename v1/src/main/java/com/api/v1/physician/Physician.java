package com.api.v1.physician;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.physician.induct.InductPhysicianDTO;
import com.api.v1.physician.update.UpdatePhysicianDTO;
import com.api.v1.system_user.SystemUser;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Entity
@Table(name = "v1_physician")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Physician implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String physicianLicenseNumber ;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private final LocalDateTime inductionDateTime = LocalDateTime.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime terminationDateTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "system_user_id")
	private SystemUser systemUser;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "physician")
	@JsonManagedReference
	private List<MedicalAppointment> appointmentList;

	public Physician(InductPhysicianDTO dto) {
		super();
		this.physicianLicenseNumber = dto.physicianLicenseNumber();
		this.systemUser = new SystemUser(dto.systemUserDTO());
	}

	public void update(UpdatePhysicianDTO dto) {
		this.systemUser.update(dto.systemUserDTO());
	}

	public void addMedicalAppointment(MedicalAppointment medicalAppointment) {
		appointmentList.add(medicalAppointment);
	}

}
