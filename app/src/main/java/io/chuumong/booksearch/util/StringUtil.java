package io.chuumong.booksearch.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public class StringUtil {


    private static final String TAG = StringUtil.class.getSimpleName();

    public static String parserDate(String strDate) {
        Date date;

        try {
            date = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).parse(strDate);
        } catch (ParseException e) {
            Log.e(TAG, "parserDate", e);
            return null;
        }


        if (date == null) {
            return null;
        }

        return new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault()).format(date);
    }

    public static String parserPrice(String price) {
        return String.format(Locale.getDefault(), "%,d원", Integer.valueOf(price));
    }
}
