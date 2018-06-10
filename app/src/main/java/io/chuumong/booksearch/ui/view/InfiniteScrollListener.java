package io.chuumong.booksearch.ui.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {

    private static final int VISIBLE_THRESHOLD = 3;

    private LinearLayoutManager layoutManager;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        if (dy < 0) {
            return;
        }

        if (layoutManager == null) {
            layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        }

        final int visibleItemCount = recyclerView.getChildCount();
        final int totalItemCount = layoutManager.getItemCount();
        final int firstVisbleItem = layoutManager.findFirstVisibleItemPosition();

        if (totalItemCount - visibleItemCount <= firstVisbleItem + VISIBLE_THRESHOLD) {
            onLoadMoer();
        }
    }

    public abstract void onLoadMoer();
}
