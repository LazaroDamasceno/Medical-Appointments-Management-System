package com.api.v1.patient.internal_use;

import com.api.v1.auxiliary.SSN;
import com.api.v1.patient.Patient;

public interface FindPatientBySsn {

	Patient findBySsn(@SSN String ssn);
}
