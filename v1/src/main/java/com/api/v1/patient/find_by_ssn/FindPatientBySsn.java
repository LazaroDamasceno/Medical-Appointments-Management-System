package com.api.v1.patient.find_by_ssn;

import com.api.v1.patient.Patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public interface FindPatientBySsn {

	Patient findBySsn(@NotBlank @Size(min=9, max=9) String ssn);
}
