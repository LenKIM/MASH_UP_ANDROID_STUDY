package io.chuumong.booksearch.data.remote;

import com.google.gson.GsonBuilder;

import io.chuumong.booksearch.BuildConfig;
import io.chuumong.booksearch.data.remote.api.ApiService;
import io.chuumong.booksearch.data.remote.model.Search;
import io.chuumong.booksearch.data.remote.util.ApiKeyInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public class NetworkrRequestModule {

    private static final String BASE_URL = "https://openapi.naver.com/v1/search/";

    private static ApiService apiService;

    public static void requestSearchBook(String qurey, int display, int start, Callback<Search> callback) {

    }

}
