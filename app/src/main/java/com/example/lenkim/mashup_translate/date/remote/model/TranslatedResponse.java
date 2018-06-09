package com.example.lenkim.mashup_translate.date.remote.model;

import com.google.gson.annotations.SerializedName;

public class TranslatedResponse {

    @SerializedName("@type")
    String type;

    @SerializedName("@service")
    String service;
    @SerializedName("@version")
    String version;

    @SerializedName("result")
    ResultResponse result;

    public ResultResponse getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TranslatedResponse{" +
                "type='" + type + '\'' +
                ", service='" + service + '\'' +
                ", version='" + version + '\'' +
                ", result=" + result +
                '}';
    }
}
