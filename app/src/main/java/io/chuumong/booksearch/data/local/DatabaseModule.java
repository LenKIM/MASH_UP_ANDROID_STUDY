package io.chuumong.booksearch.data.local;

import android.content.Context;

import java.util.List;

import io.chuumong.booksearch.data.local.dao.SearchHistoryDao;
import io.chuumong.booksearch.data.local.model.SearchHistory;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public class DatabaseModule {

    private static AppDatabase appDatabase;
    private static SearchHistoryDao searchHistoryDao;

    public static void save(Context context, SearchHistory searchHistory) {
    }

    public static List<SearchHistory> getAll(Context context) {
        return null;
    }

    public static void delete(Context context, long id) {
    }
}
