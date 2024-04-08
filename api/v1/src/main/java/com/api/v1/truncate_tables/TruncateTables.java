package com.api.v1.truncate_tables;

import org.springframework.http.ResponseEntity;

public interface TruncateTables {
    
    ResponseEntity<Void> truncateTables();

}
