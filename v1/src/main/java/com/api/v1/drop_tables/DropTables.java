package com.api.v1.drop_tables;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

public interface DropTables {
    
    CompletableFuture<ResponseEntity<Void>> dropTables();

}
