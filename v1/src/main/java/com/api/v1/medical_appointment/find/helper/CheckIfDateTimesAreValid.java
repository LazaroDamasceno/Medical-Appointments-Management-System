package com.api.v1.medical_appointment.find.helper;

import java.time.LocalDateTime;

public interface CheckIfDateTimesAreValid {

    void checkIfFirstDateTimeIsBeyondLastDateTime(LocalDateTime firstDateTime, LocalDateTime lastDateTime);

}
