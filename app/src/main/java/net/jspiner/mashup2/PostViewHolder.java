package net.jspiner.mashup2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private Context context;
    private ImageView profileImage;
    private TextView name;
    private TextView date;
    private TextView content;
    private ImageView contentImage;

    public PostViewHolder(View itemView) {
        super(itemView);

        context = itemView.getContext();
        profileImage = itemView.findViewById(R.id.profile_image);
        name = itemView.findViewById(R.id.name);
        date = itemView.findViewById(R.id.date);
        content = itemView.findViewById(R.id.content);
        contentImage = itemView.findViewById(R.id.content_image);

        itemView.findViewById(R.id.like).setOnClickListener(__ -> {});
        itemView.findViewById(R.id.comment).setOnClickListener(__ -> {});
        itemView.findViewById(R.id.share).setOnClickListener(__ -> {});
    }

    public void setData(Post post) {
        Glide.with(context)
                .load(post.writer.profileImage)
                .into(profileImage);

        name.setText(post.writer.name);
        date.setText(timestampToDate(post.date));
        content.setText(post.conten);

        Glide.with(context)
                .load(NetworkRequest.API_URL + post.contentImage)
                .into(contentImage);
    }

    private String timestampToDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");
        Date netDate = (new Date(timestamp * 1000l));
        return sdf.format(netDate);
    }

}
