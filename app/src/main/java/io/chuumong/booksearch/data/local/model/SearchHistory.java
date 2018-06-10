package io.chuumong.booksearch.data.local.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

/**
 * Created by jonghunlee on 2018-05-25.
 */

//@Entity(tableName = "search_history", indices = {@Index("id")})
public class SearchHistory {

    private long id;

    private String search;
    private long date;

    public String getSearch() {
        return search;
    }

    public long getDate() {
        return date;
    }
}
