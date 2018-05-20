package net.jspiner.mashup2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;


public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {


    private ArrayList<Post> dataList;

    public PostAdapter() {
        this.dataList = new ArrayList<>();
    }

    public void setDate(ArrayList<Post> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PostViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(
                                R.layout.card_post,
                                parent,
                                false
                        )
        );
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
