
package com.api.v1.system_user;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v1_system_user")
@Getter
@Setter
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
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date birthDate;
	
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
		this.birthDate = dto.birthDate();
		this.email = dto.email();
		this.phoneNumber = dto.phoneNumber();
		this.gender = dto.gender();
	}
	
}
