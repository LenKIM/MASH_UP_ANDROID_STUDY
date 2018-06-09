package com.example.lenkim.mashup_translate.date.remote;

import com.example.lenkim.mashup_translate.BuildConfig;
import com.example.lenkim.mashup_translate.date.remote.api.ApiService;
import com.example.lenkim.mashup_translate.date.remote.model.Result;
import com.example.lenkim.mashup_translate.date.remote.model.TranslatedResponse;
import com.example.lenkim.mashup_translate.date.remote.util.ApiKeyIntercepter;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRequestModule {

    private static final String BASE_URL = "https://openapi.naver.com/v1/papago/";

    private static ApiService apiService;

    public static ApiService getService() {
        if(apiService == null){
            apiService = getApiService();
        }
        return apiService;
    }

    private static ApiService getApiService() {
        final OkHttpClient okHttpClient = getOkHttpClient();
        final Retrofit retrofit = getRetrofit(okHttpClient);

        return retrofit.create(ApiService.class);
    }

    private static Retrofit getRetrofit(OkHttpClient okHttpClient) {
        final Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient);
        builder.baseUrl(BASE_URL);
        builder.addConverterFactory(GsonConverterFactory.create());
        return builder.build();
    }

    public static void requestTranslate(String source, String target, String text, Callback<Result> callback) {
        getService().getTranslatedText(source, target, text).enqueue(callback);
    }

    private static OkHttpClient getOkHttpClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }

        builder.addInterceptor(new ApiKeyIntercepter());

        return builder.build();
    }
}
