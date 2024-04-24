package com.api.v1.physician.find_all;

import java.util.List;

import com.api.v1.physician.Physician;

interface FindPhysiciansService {
	
	List<Physician> findAll();

}
