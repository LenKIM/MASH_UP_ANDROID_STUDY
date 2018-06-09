package com.example.lenkim.mashup_translate.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String parserHistoryDate(long date) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault()).format(
                new Date(date));
    }
}
