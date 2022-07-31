package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsfeedComments {

    @SerializedName("can_post")
    @Expose
    int can_post;

    @Expose
    int count;

    public int getCan_post() {
        return can_post;
    }

    public int getCount() {
        return count;
    }
}
