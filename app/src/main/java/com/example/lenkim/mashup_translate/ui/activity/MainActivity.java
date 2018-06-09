package com.example.lenkim.mashup_translate.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.lenkim.mashup_translate.R;
import com.example.lenkim.mashup_translate.date.local.DatabaseModule;
import com.example.lenkim.mashup_translate.date.local.model.SearchHistory;
import com.example.lenkim.mashup_translate.date.remote.NetworkRequestModule;
import com.example.lenkim.mashup_translate.date.remote.model.Result;
import com.example.lenkim.mashup_translate.date.remote.model.ResultResponse;
import com.example.lenkim.mashup_translate.ui.adapter.SearchAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    public static final String KOREAN = "ko";
    public static final String ENGLISH = "en";

    @BindView(R.id.tw_change_from)
    TextView twChangeFrom;

    @BindView(R.id.bt_change)
    ImageButton btChange;

    @BindView(R.id.tw_change_to)
    TextView twChangeTo;

    @BindView(R.id.et_user_input)
    EditText userInput;

    @BindView(R.id.tw_show_to_user)
    TextView showToUser;

    @BindView(R.id.rw_list)
    RecyclerView rvList;

    @BindView(R.id.bt_transAction)
    Button action;

    SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setTitle("Mashup Translate");
        toolbar.setTitleTextAppearance(this, R.style.DancingTextAppearance);
        searchAdapter = new SearchAdapter();
        rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvList.setAdapter(searchAdapter);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String text = userInput.getText().toString();
                Log.e("MainActivity", text);
                requestTranslate(text);
            }
        });
    }

    private void requestTranslate(final String orgin) {

        NetworkRequestModule.requestTranslate(KOREAN, ENGLISH, orgin, new Callback<Result>() {
            @Override
            public void onResponse(@NonNull Call<Result> call, @NonNull Response<Result> response) {
                Result result = response.body();
                ResultResponse responseText = result.getResponse().getResult();
                String translated = responseText.getTranslatedText();
                String srcTypeFrom = responseText.getSrcLangType();
                String tarTypeFrom = responseText.getTarLangType();

                showToUser.setText(translated);

                DatabaseModule.save(getApplicationContext(), new SearchHistory(0, srcTypeFrom, tarTypeFrom, orgin, translated));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<SearchHistory> histories = DatabaseModule.getAll(getApplicationContext());
                        searchAdapter.clear();
                        searchAdapter.addAll(histories);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Result> call, @NonNull Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
