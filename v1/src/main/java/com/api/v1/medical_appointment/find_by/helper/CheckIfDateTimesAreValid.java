package com.api.v1.medical_appointment.find_by.helper;

import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

public interface CheckIfDateTimesAreValid {

    void checkEquality(BetweenDatesTimesDTO dto);

    void checkIfFirstDateTimeIsBeyondLastDateTime(BetweenDatesTimesDTO dto);

    void checkIfLastDateTimeIsBeyondFirstDateTime(BetweenDatesTimesDTO dto);

}
