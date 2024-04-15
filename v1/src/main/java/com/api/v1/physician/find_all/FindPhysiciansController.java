package com.api.v1.physician.find_all;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.physician.Physician;

public interface FindPhysiciansController {

    public ResponseEntity<List<Physician>> findAll();
    
}
