package com.api.v1.physician.find_by_mln;

import com.api.v1.physician.Physician;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface FindPhysicianByMln {

	Physician findByMln(@NotNull @Size(min=9, max=9) String mln);
	
}
