package com.api.v1.medical_appointment.find_by.helper;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.DateTimeConverter;
import com.api.v1.helper.TemporalOrderException;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

@Service
public class CheckIfDateTimesAreValidImpl implements CheckIfDateTimesAreValid {

    @Override
    @Transactional(readOnly = true)
    public void checkIfFirstDateTimeIsBeyondLastDateTime(BetweenDatesTimesDTO dto) {
        if (getFirstDateTime(dto).isAfter(getLastDateTime(dto))) {
            throw new TemporalOrderException();
        }
    }

    private ZonedDateTime getFirstDateTime(BetweenDatesTimesDTO dto) {
        return DateTimeConverter.convertToZonedDateTime(dto.firstDateTime());
    }

    private ZonedDateTime getLastDateTime(BetweenDatesTimesDTO dto) {
        return DateTimeConverter.convertToZonedDateTime(dto.lastDateTime());
    }
    
}
