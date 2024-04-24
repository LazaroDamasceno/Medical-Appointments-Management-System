package com.api.v1.patient.find_all;

import java.util.List;

import com.api.v1.patient.Patient;

interface FindPatientsService {
	
	List<Patient> findAll();

}
