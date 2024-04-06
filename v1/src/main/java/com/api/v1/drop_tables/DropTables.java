package com.api.v1.drop_tables;

import org.springframework.http.ResponseEntity;

public interface DropTables {
    
    ResponseEntity<Void> dropTables();

}
