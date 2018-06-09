package com.example.lenkim.mashup_translate.date.remote.api;

import com.example.lenkim.mashup_translate.date.remote.model.Result;
import com.example.lenkim.mashup_translate.date.remote.model.TranslatedResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
 * if you want to find more detailed API Guides
 * https://developers.naver.com/docs/papago/papago-nmt-api-reference.md
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("n2mt")
    Call<Result> getTranslatedText(
            @Field("source") String source,
            @Field("target") String target,
            @Field("text") String text);

}
