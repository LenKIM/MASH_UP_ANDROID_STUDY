package io.chuumong.booksearch.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import io.chuumong.booksearch.data.local.model.SearchHistory;

/**
 * Created by jonghunlee on 2018-05-25.
 */

//@Database(version = 1, entities = {SearchHistory.class})
public abstract class AppDatabase extends RoomDatabase {

    public static final String DB_NAME = "app_db";


}
