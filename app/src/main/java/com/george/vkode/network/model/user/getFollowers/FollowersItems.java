package com.george.vkode.network.model.user.getFollowers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FollowersItems {

    @SerializedName("id")
    @Expose
    int id;

    @Expose
    int online;

    @Expose
    String first_name;

    @Expose
    String last_name;

    public int getId() {
        return id;
    }

    public int getOnline() {
        return online;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
