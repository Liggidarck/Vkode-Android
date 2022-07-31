package com.george.vkode.network.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupItems {

    @SerializedName("id")
    @Expose
    int id;

    @Expose
    String name;

    @Expose
    String screen_name;

    @Expose
    int is_closed;

    @Expose
    String deactivated;

    @Expose
    int is_admin;

    @Expose
    int admin_level;

    @Expose
    int is_member;

    @Expose
    int is_advertiser;

    @Expose
    int invited_by;

    @Expose
    String type;

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

    public int getIs_closed() {
        return is_closed;
    }

    public String getDeactivated() {
        return deactivated;
    }

    public int getIs_admin() {
        return is_admin;
    }

    public int getAdmin_level() {
        return admin_level;
    }

    public int getIs_member() {
        return is_member;
    }

    public int getIs_advertiser() {
        return is_advertiser;
    }

    public int getInvited_by() {
        return invited_by;
    }

    public String getType() {
        return type;
    }

    public String getPhoto_100() {
        return photo_100;
    }

    public String getPhoto_200() {
        return photo_200;
    }
}
