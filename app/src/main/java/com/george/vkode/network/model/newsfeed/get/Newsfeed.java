package com.george.vkode.network.model.newsfeed.get;

import com.george.vkode.network.model.common.group.Group;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Newsfeed {

    @SerializedName("items")
    @Expose
    List<NewsfeedItem> items;

    @Expose
    List<Group> groups;

    @Expose
    String next_from;


    public List<NewsfeedItem> getItems() {
        return items;
    }

    public String getNext_from() {
        return next_from;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
