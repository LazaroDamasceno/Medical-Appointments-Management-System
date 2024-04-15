package com.api.v1.physician.terminate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface TerminatePhysicianService {

	void terminate(@NotNull @Size(min=7, max=7) String physicanLicenseNumber);
	
}
