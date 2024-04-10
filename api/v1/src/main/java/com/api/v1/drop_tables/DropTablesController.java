package com.api.v1.drop_tables;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class DropTablesController implements DropTables {

    private final DropTablesService service;

    @Override
    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> dropTables() {
        return service.dropTables();
    }
    
}
