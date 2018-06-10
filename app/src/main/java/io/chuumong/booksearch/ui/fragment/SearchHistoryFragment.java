package io.chuumong.booksearch.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import butterknife.BindView;
import io.chuumong.booksearch.R;
import io.chuumong.booksearch.data.local.model.SearchHistory;
import io.chuumong.booksearch.ui.adapter.SearchHistoryAdapter;


/**
 * Created by jonghunlee on 2018-05-25.
 */
public class SearchHistoryFragment extends Fragment {

    @BindView(R.id.list_search_history)
    RecyclerView rvSearchHistory;

    @BindView(R.id.progress)
    ProgressBar progress;

    private SearchHistoryAdapter searchHistoryAdapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
//            progress.setVisibility(View.VISIBLE);
//            List<SearchHistory> searchHistories = DatabaseModule.getAll(getActivity());
//            searchHistoryAdapter.addAll(searchHistories);
//            progress.setVisibility(View.GONE);
        }

        super.setUserVisibleHint(isVisibleToUser);
    }

}
