package com.api.v1.auxiliary.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.api.v1.auxiliary.DateTimeConverter;

@Service
public class CheckIfDateTimesAreValidOmpl implements CheckIfDateTimesAreValid {

    @Override
    public void checkEquality(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        if (firstDateTime.isEqual(lastDateTime)) throw new DateTimesEqualityException();
    }

    private LocalDateTime firstDateTime;
    private LocalDateTime lastDateTime;

    @Override
    public void checkEquality(String firstDateTime, String lastDateTime) {
        this.firstDateTime = DateTimeConverter.convertToDateTime(firstDateTime);
        this.lastDateTime = DateTimeConverter.convertToDateTime(lastDateTime);
        if (this.firstDateTime.isEqual(this.lastDateTime)) throw new DateTimesEqualityException();
    }
    
}
