package com.api.v1.physician.hire;

import jakarta.validation.constraints.NotNull;

interface HirePhysicianService {
	
	void register(@NotNull HirePhysicianDTO dto);

}
