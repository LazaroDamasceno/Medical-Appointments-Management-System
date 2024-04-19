package com.api.v1.auxiliary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateConverter {
    
    static LocalDate convert(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateTime, dtf);
    }

}
