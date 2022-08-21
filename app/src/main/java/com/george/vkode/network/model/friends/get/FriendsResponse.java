package com.george.vkode.network.model.friends.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FriendsResponse {

    @SerializedName("count")
    @Expose
    int count;

    @Expose
    List<FriendsItems> items;

    public int getCount() {
        return count;
    }

    public List<FriendsItems> getItems() {
        return items;
    }
}
