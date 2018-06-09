package com.example.lenkim.mashup_translate.date.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.lenkim.mashup_translate.date.local.model.SearchHistory;

import java.util.List;

@Dao
public interface SearchHistoryDao {

    @Insert
    void insert(SearchHistory searchHistory);

    @Query("SELECT * FROM search_history ORDER BY id DESC")
    List<SearchHistory> getAllHistory();

    @Query("DELETE FROM search_history WHERE id = :id")
    void delete(long id);

    @Query("SELECT * FROM search_history WHERE id = :id")
    SearchHistory get(long id);


    @Delete
    void delete(SearchHistory searchHistory);
}
