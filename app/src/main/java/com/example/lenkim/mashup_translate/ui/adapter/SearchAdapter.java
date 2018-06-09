package com.example.lenkim.mashup_translate.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenkim.mashup_translate.R;
import com.example.lenkim.mashup_translate.date.local.model.SearchHistory;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {


    private List<SearchHistory> texts = new ArrayList<>();

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_search_history_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.bind(texts.get(position));
    }

    @Override
    public int getItemCount() {
        return texts.size();
    }

    public void clear(){
        texts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<SearchHistory> texts){
        this.texts.addAll(texts);
        notifyDataSetChanged();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_from_item)
        TextView fromLangText;

        @BindView(R.id.tv_to_item)
        TextView toLangText;

        SearchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(final SearchHistory inputText){
            fromLangText.setText(inputText.getSearchOriginText());
            toLangText.setText(inputText.getSearchTranslatedText());
        }
    }


}
