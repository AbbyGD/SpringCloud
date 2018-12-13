package com.ifenqu.webapi.provider.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static Date parseShortDate(String s) throws ParseException{
        return shortDateFormat.parse(s);
    }
}
