
package com.api.v1.system_user;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.api.v1.helper.DateTimeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Entity
@Table(name = "v1_system_user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SystemUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false, unique = true)
	private String ssn;
	
	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String gender;

	public SystemUser(@NotNull RegisterSystemUserDTO dto) {
		super();
		this.fullName = dto.fullName();
		this.ssn = dto.ssn();
		this.birthDate = DateTimeConverter.convertToLocalDate(dto.birthDate());
		this.email = dto.email();
		this.phoneNumber = dto.phoneNumber();
		this.gender = dto.gender();
	}

	public void update(UpdateSystemUserDTO dto) {
		this.fullName = dto.fullName();
		this.birthDate = DateTimeConverter.convertToLocalDate(dto.birthDate());
		this.email = dto.email();
		this.phoneNumber = dto.phoneNumber();
		this.gender = dto.gender();
	}
	
}
