package com.example.lenkim.mashup_translate.date.local.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "search_history", indices = {@Index("id")})
public class SearchHistory {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String searchLangTo;
    private String searchLangFrom;

    private String searchOriginText;
    private String searchTranslatedText;

    public SearchHistory(long id, String searchLangTo, String searchLangFrom, String searchOriginText, String searchTranslatedText) {
        this.id = id;
        this.searchLangTo = searchLangTo;
        this.searchLangFrom = searchLangFrom;
        this.searchOriginText = searchOriginText;
        this.searchTranslatedText = searchTranslatedText;
    }

    public long getId() {
        return id;
    }

    public String getSearchLangTo() {
        return searchLangTo;
    }

    public String getSearchLangFrom() {
        return searchLangFrom;
    }

    public String getSearchOriginText() {
        return searchOriginText;
    }

    public String getSearchTranslatedText() {
        return searchTranslatedText;
    }

    @Override
    public String toString() {
        return "SearchHistory{" +
                "searchLangTo='" + searchLangTo + '\'' +
                ", searchLangFrom='" + searchLangFrom + '\'' +
                ", searchOriginText='" + searchOriginText + '\'' +
                ", searchTranslatedText='" + searchTranslatedText + '\'' +
                '}';
    }
}
