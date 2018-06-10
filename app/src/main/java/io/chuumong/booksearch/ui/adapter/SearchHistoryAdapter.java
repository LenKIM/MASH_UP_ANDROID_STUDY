package io.chuumong.booksearch.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.chuumong.booksearch.R;
import io.chuumong.booksearch.data.local.model.SearchHistory;
import io.chuumong.booksearch.util.DateUtil;
import io.chuumong.booksearch.util.UiUtil;

/**
 * Created by jonghunlee on 2018-05-25.
 */
public class SearchHistoryAdapter {

    private final List<SearchHistory> searchHistories = new ArrayList<>();
    private final OnClickSearchHistoryListener listener;

    public SearchHistoryAdapter(OnClickSearchHistoryListener listener) {
        this.listener = listener;
    }


    class SearchHistoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_history)
        TextView tvHistory;

        @BindView(R.id.text_date)
        TextView tvDate;

        @BindView(R.id.button_delete)
        ImageButton ibDelete;

        SearchHistoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final SearchHistory searchHistory) {
            if (getAdapterPosition() == 0) {
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) itemView.getLayoutParams();
                params.topMargin = (int) UiUtil.convertDpToPx(8);
                itemView.setLayoutParams(params);
            }

            tvHistory.setText(searchHistory.getSearch());
            tvDate.setText(DateUtil.parserHistoryDate(searchHistory.getDate()));

            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickDelete(searchHistory, getAdapterPosition());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickItem(searchHistory);
                }
            });
        }
    }

    public interface OnClickSearchHistoryListener {
        void onClickItem(SearchHistory searchHistory);

        void onClickDelete(SearchHistory searchHistory, int position);
    }

}
