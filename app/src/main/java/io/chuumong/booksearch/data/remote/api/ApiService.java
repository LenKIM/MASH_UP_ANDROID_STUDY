package io.chuumong.booksearch.data.remote.api;

import io.chuumong.booksearch.data.remote.model.Search;
import retrofit2.Call;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public interface ApiService {


    Call<Search> getSearchBook(String query, int display, int start);

}
