package net.jspiner.mashup2;

import com.google.gson.annotations.SerializedName;

/**
 * Created by len on 19/05/2018.
 */

public class Post {

    public String conten;

    @SerializedName("content_image")
    public String contentImage;

    public long date;

    @SerializedName("post_id")
    public long postId;

    public Writer writer;

}
