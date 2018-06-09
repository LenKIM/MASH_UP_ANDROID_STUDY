
package com.example.lenkim.mashup_translate.date.remote.util;

import com.example.lenkim.mashup_translate.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyIntercepter implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request()
                .newBuilder()
                .addHeader("X-Naver-Client-Id", BuildConfig.API_CLIENT_ID)
                .addHeader("X-Naver-Client-Secret", BuildConfig.API_CLIENT_SECRET)
                .build();

        return chain.proceed(request);
    }
}
