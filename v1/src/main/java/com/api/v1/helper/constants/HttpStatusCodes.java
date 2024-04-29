package com.api.v1.helper.constants;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class HttpStatusCodes {

	public static final ResponseEntity<Void> CREATED_201 = new ResponseEntity<>(HttpStatusCode.valueOf(201));
	
	public static final ResponseEntity<Void> NO_CONTENT_204 = new ResponseEntity<>(HttpStatusCode.valueOf(204));
	
}
