package com.api.v1.patient.helper;

import com.api.v1.helper.customized_annotations.SSN;
import com.api.v1.patient.Patient;

public interface FindPatientBySsn {

	Patient findBySsn(@SSN String ssn);
}
