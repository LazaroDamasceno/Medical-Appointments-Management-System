package com.api.v1.medical_appointment.find.helper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.TemporalOrderException;

@Service
public class CheckIfDateTimesAreValidImpl implements CheckIfDateTimesAreValid {

    @Override
    @Transactional(readOnly = true)
    public void checkIfFirstDateTimeIsBeyondLastDateTime(LocalDateTime firstDateTime, LocalDateTime lastDateTime) {
        if (firstDateTime.isAfter(lastDateTime)) {
            throw new TemporalOrderException();
        }
    }
    
}
