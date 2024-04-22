package com.api.v1.auxiliary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateTimeConverter {
    
    public static LocalDateTime convert(String dateTime) {
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
