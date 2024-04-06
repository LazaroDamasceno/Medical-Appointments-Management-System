package com.api.v1.physician.find_all;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

import com.api.v1.physician.Physician;

public interface FindPhysicians {
	
	CompletableFuture<ResponseEntity<List<Physician>>> findAll();

}
