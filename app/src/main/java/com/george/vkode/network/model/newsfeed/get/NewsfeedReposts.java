package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsfeedReposts {

    @SerializedName("count")
    @Expose
    int count;

    @Expose
    int user_reposted;

    public int getCount() {
        return count;
    }

    public int getUser_reposted() {
        return user_reposted;
    }
}
