package com.api.v1.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public interface DateTimeConverter {

    static LocalDate convertToLocalDate(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateTime, dtf);
    }
    
    static ZonedDateTime convertToZonedDateTime(String dateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(dateTime, dtf).atZone(zoneId);
    }

}
