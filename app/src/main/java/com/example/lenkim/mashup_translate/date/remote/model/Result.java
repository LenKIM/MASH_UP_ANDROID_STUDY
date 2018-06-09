package com.example.lenkim.mashup_translate.date.remote.model;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("message")
    private TranslatedResponse response;

    public TranslatedResponse getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "Result{" +
                "response=" + response +
                '}';
    }
}
