package com.george.vkode.network.model.user.getFollowers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Followers {

    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("first_name")
    @Expose
    String first_name;

    @Expose
    String last_name;

    @Expose
    String photo_200;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhoto_200() {
        return photo_200;
    }
}
