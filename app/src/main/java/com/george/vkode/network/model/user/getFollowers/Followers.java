package com.george.vkode.network.model.user.getFollowers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Followers {

    @SerializedName("count")
    @Expose
    int count;

    @Expose
    List<FollowersItems> items;

    public int getCount() {
        return count;
    }

    public List<FollowersItems> getItems() {
        return items;
    }
}
