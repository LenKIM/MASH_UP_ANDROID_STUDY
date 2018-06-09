package com.example.lenkim.mashup_translate.date.local;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.lenkim.mashup_translate.date.local.dao.SearchHistoryDao;
import com.example.lenkim.mashup_translate.date.local.model.SearchHistory;

import java.util.List;

public class DatabaseModule {

    private static AppDatabase appDatabase;
    private static SearchHistoryDao searchHistoryDao;

    public static AppDatabase getAppDatabase(Context context) {
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public static SearchHistoryDao getSearchHistoryDao(Context context) {
        if(searchHistoryDao == null){
            searchHistoryDao = getAppDatabase(context).searchHistoryDao();
        }
        return searchHistoryDao;
    }

    public static void save(Context context, SearchHistory searchHistory){
        getSearchHistoryDao(context).insert(searchHistory);
    }

    public static SearchHistory get(Context context, int i){
        return getSearchHistoryDao(context).get(i);
    }

    public static List<SearchHistory> getAll(Context context){
        return getSearchHistoryDao(context).getAllHistory();
    }

    public static void delete(Context context, long id){
        getSearchHistoryDao(context).delete(id);
    }
}
