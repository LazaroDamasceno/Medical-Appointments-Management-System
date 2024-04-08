package com.api.v1.truncate_tables;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/db_tables")
@RequiredArgsConstructor
public class TruncateTablesController implements TruncateTables {

    private final TruncateTablesService service;

    @Override
    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> truncateTables() {
        return service.truncateTables();
    }
    
}
