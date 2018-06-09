package com.example.lenkim.mashup_translate.date.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lenkim.mashup_translate.date.local.dao.SearchHistoryDao;
import com.example.lenkim.mashup_translate.date.local.model.SearchHistory;

@Database(version = 1, entities = {SearchHistory.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME ="app_db";
    public abstract SearchHistoryDao searchHistoryDao();

}
