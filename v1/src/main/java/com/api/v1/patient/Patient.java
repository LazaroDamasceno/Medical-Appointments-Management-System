package com.api.v1.patient;

import java.io.Serializable;
import java.util.UUID;

import com.api.v1.patient.register.RegisterPatientDTO;
import com.api.v1.patient.update.UpdatePatientDTO;
import com.api.v1.system_user.SystemUser;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "v1_patient")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Patient implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(nullable = false)
	private String address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "system_user_id")
	private SystemUser systemUser;

	public Patient(RegisterPatientDTO dto) {
		this.address = dto.address();
		this.systemUser = new SystemUser(dto.systemUser());
	}

	public void update(UpdatePatientDTO dto) {
		this.address = dto.address();
		this.systemUser.update(dto.systemUserDTO());
	}
	
}
