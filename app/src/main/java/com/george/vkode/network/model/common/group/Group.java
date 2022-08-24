package com.george.vkode.network.model.common.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("id")
    @Expose
    int id;

    @Expose
    String name;

    @Expose
    String screen_name;

    @Expose
    String type;

    @Expose
    int is_admin;

    @Expose
    int is_member;

    @Expose
    int is_advertiser;

    @Expose
    String photo_50;

    @Expose
    String photo_100;

    @Expose
    String photo_200;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public String getType() {
        return type;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public int getIs_member() {
        return is_member;
    }

    public int getIs_advertiser() {
        return is_advertiser;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public String getPhoto_200() {
        return photo_200;
    }
}
