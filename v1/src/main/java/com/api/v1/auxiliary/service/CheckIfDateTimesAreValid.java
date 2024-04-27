package com.api.v1.auxiliary.service;

import java.time.LocalDateTime;

public interface CheckIfDateTimesAreValid {

    void checkEquality(LocalDateTime firstDateTime, LocalDateTime lastDateTime);

    void checkEquality(String firstDateTime, String lastDateTime);
    
}
