package com.api.v1.physician;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.physician.hire.HirePhysicianDTO;
import com.api.v1.physician.update.UpdatePhysicianDTO;
import com.api.v1.system_user.SystemUser;

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
	
	private final LocalDateTime inductionDateTime = LocalDateTime.now();
	
	private LocalDateTime terminationDateTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "system_user_id")
	private SystemUser systemUser;

	public Physician(HirePhysicianDTO dto) {
		super();
		this.physicianLicenseNumber = dto.physicianLicenseNumber();
		this.systemUser = new SystemUser(dto.systemUserDTO());
	}

	public void update(UpdatePhysicianDTO dto) {
		this.systemUser.update(dto.systemUserDTO());
	}

}
