package com.api.v1.physician;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.api.v1.physician.induct.InductPhysicianDTO;
import com.api.v1.system_user.SystemUser;
import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "v1_physician")
@Getter
@Setter
public class Physician implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	// MLN stands for medical license number
	@Column(nullable = false, unique = true)
	private final String mln;
	
	private final LocalDateTime inductionDateTime = LocalDateTime.now();
	
	private LocalDateTime terminationDateTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "system_user_id")
	private SystemUser systemUser;

	public Physician(InductPhysicianDTO dto) {
		super();
		this.mln = dto.mln();
		this.systemUser = new SystemUser(dto.systemUserDTO());
	}

	public void update(UpdatedSystemUserDTO dto) {
		this.systemUser.update(dto);
	}

}
