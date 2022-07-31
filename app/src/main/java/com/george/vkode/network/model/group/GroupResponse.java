package com.george.vkode.network.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GroupResponse implements Serializable {

    @SerializedName("count")
    @Expose
    int count;

    @SerializedName("items")
    @Expose
    List<GroupItems> items;

    public int getCount() {
        return count;
    }

    public List<GroupItems> getItems() {
        return items;
    }
}
