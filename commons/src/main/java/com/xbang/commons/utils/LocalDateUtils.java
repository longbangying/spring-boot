package com.xbang.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description
 *
 * @author admin
 * @version: 1.0
 * create date: 2020/11/13
 * update date: 2020/11/13
 */
public class LocalDateUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String localDateToString(LocalDate localDate){
        return DATE_FORMATTER.format(localDate);
    }

    public static String localDateTimeToString(LocalDateTime localDateTime){
        return DATE_TIME_FORMATTER.format(localDateTime);
    }

}
