package com.api.v1.physician.induct;

import jakarta.validation.constraints.NotNull;

public interface InductPhysicianService {
	
	void register(@NotNull InductPhysicianDTO dto);

}
