package com.example.lenkim.mashup_translate.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class UiUtil {

    public static float convertPxToDp(float px) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return Math.round(dp);
    }

    public static float convertDpToPx(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    private float dpFromPx(Context context, float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    private float pxFromDp(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
