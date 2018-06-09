package com.example.lenkim.mashup_translate.date.remote.model;

import com.google.gson.annotations.SerializedName;

public class ResultResponse {

    @SerializedName("srcLangType")
    private String srcLangType;

    @SerializedName("tarLangType")
    private String tarLangType;

    @SerializedName("translatedText")
    private String translatedText;

    private String originText;

    public String getSrcLangType() {
        return srcLangType;
    }

    public String getTarLangType() {
        return tarLangType;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public String getOriginText() {
        return originText;
    }

    @Override
    public String toString() {
        return "ResultResponse{" +
                "srcLangType='" + srcLangType + '\'' +
                ", tarLangType='" + tarLangType + '\'' +
                ", translatedText='" + translatedText + '\'' +
                ", originText='" + originText + '\'' +
                '}';
    }
}
