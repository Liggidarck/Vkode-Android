package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Newsfeed {

    @SerializedName("items")
    @Expose
    List<NewsfeedItems> items;

    @Expose
    String next_from;


    public List<NewsfeedItems> getItems() {
        return items;
    }

    public String getNext_from() {
        return next_from;
    }
}
