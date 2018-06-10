package io.chuumong.booksearch.data.local.dao;

import android.arch.persistence.room.Dao;

import java.util.List;

import io.chuumong.booksearch.data.local.model.SearchHistory;

/**
 * Created by jonghunlee on 2018-05-25.
 */

@Dao
public interface SearchHistoryDao {

    void insert(SearchHistory searchHistory);

    List<SearchHistory> getAllHistory();

    void delete(long id);

    void delete(SearchHistory searchHistory);
}
