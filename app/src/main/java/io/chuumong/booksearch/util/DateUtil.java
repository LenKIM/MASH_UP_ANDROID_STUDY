package io.chuumong.booksearch.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public class DateUtil {

    public static String parserHistoryDate(long date) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault()).format(
                new Date(date));
    }
}
