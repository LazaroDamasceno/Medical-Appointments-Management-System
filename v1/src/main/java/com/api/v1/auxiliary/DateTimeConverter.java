package com.api.v1.auxiliary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateTimeConverter {
    
    static LocalDateTime convert(String dateTime) {
        if (dateTime.contains("/")) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDateTime.parse(dateTime, dtf);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, dtf);
    }


}
