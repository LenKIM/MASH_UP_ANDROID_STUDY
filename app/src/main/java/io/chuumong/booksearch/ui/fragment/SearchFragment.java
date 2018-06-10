package io.chuumong.booksearch.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import butterknife.BindView;
import io.chuumong.booksearch.R;
import io.chuumong.booksearch.ui.adapter.SearchAdapter;


/**
 * Created by jonghunlee on 2018-05-25.
 */
public class SearchFragment extends Fragment {
    private static final String TAG = SearchFragment.class.getSimpleName();

    private static final int MAX_SEARCH_COUNT = 20;

    @BindView(R.id.search_view)
    SearchView searchView;

    @BindView(R.id.list_search)
    RecyclerView rvSearch;

    @BindView(R.id.layout_empty_list_message)
    FrameLayout flEmptyListMessage;

    @BindView(R.id.progress)
    ProgressBar progress;

    private SearchAdapter searchAdapter;

    private int currentStart = 1;
    private int totalCount = 0;
    private String currentSearchQuery;
    private boolean isSearch;

    private void requestSearchBook(final String query) {

    }

    private void moreRequestSearchBook() {

    }

    private void initSearchInfo(String query) {
        currentStart = 1;
        totalCount = 0;
        currentSearchQuery = query;
    }

    private void setIsSearch(boolean isSearch) {
        this.isSearch = isSearch;
    }

    private void addSearchCount() {
        currentStart += MAX_SEARCH_COUNT;
    }

    private boolean checkMaxTotalCount() {
        return totalCount <= currentStart;
    }

    private void checkListSearchItem() {
//        if (searchAdapter.getItemCount() == 0) {
//            showListSearch(false);
//        } else {
//            showListSearch(true);
//        }
    }

    private void showListSearch(boolean isShow) {
        rvSearch.setVisibility(isShow ? View.VISIBLE : View.GONE);
        flEmptyListMessage.setVisibility(isShow ? View.GONE : View.VISIBLE);
    }

    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    public void sendSearch(String search) {
        searchView.onActionViewExpanded();
        searchView.setQuery(search, true);
    }
}