package com.george.vkode.network.model.user.getFollowers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FollowersResponse implements Serializable {

    @SerializedName("count")
    @Expose
    int count;

    @SerializedName("items")
    @Expose
    List<Followers> items;

    public int getCount() {
        return count;
    }

    public List<Followers> getItems() {
        return items;
    }
}
