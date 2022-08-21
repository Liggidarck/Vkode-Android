package com.george.vkode.network.model.user.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    int id;

    @Expose
    String first_name;

    @Expose
    String last_name;

    @Expose
    String deactivated;

    @Expose
    boolean is_closed;

    @Expose
    boolean can_access_closed;

    @Expose
    String photo_100;

    @Expose
    String photo_max_orig;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public boolean isCan_access_closed() {
        return can_access_closed;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public String getPhoto_max_orig() {
        return photo_max_orig;
    }
}
