package com.api.v1.drop_tables;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class DropTablesController implements DropTables {

    private final DropTablesService service;

    @Override
    @DeleteMapping
    @Async
    public ResponseEntity<Void> dropTables() {
        return service.dropTables();
    }
    
}
