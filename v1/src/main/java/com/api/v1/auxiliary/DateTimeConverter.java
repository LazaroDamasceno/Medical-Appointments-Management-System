package com.api.v1.auxiliary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateTimeConverter {

    static LocalDate convertToLocalDate(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateTime, dtf);
    }
    
    static LocalDateTime convert(String dateTime) {
        return dateTime.contains("/") ? withSlash(dateTime) : withHifen(dateTime);
    }

    private static LocalDateTime withSlash(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.parse(dateTime, dtf);
    }

    private static LocalDateTime withHifen(String dateTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDateTime.parse(dateTime, dtf);
    }


}
