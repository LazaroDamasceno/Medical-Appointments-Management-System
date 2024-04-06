package com.api.v1.truncate_tables;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;

public interface TruncateTables {

    CompletableFuture<ResponseEntity<Void>> truncateTables();
    
} 
