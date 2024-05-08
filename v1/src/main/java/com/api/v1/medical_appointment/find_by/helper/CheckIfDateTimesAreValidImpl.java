package com.api.v1.medical_appointment.find_by.helper;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helpers.TemporalOrderException;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

@Service
public class CheckIfDateTimesAreValidImpl implements CheckIfDateTimesAreValid {

    @Override
    @Transactional(readOnly = true)
    @Cacheable
    public void checkIfFirstDateTimeIsBeyondLastDateTime(BetweenDatesTimesDTO dto) {
        if (dto.firstDateTime().isAfter(dto.lastDateTime())) {
            throw new TemporalOrderException();
        }
    }
    
}
