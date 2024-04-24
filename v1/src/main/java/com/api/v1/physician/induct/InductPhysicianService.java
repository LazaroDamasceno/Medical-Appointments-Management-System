package com.api.v1.physician.induct;

import jakarta.validation.constraints.NotNull;

interface InductPhysicianService {
	
	void register(@NotNull InductPhysicianDTO dto);

}
