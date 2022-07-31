package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsfeedViews {

    @SerializedName("count")
    @Expose
    int count;

    public int getCount() {
        return count;
    }
}
