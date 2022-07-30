package com.george.vkode.network.model.account.profileInfo;

import com.george.vkode.network.model.users.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProfileInfo {

    @SerializedName("id")
    @Expose
    int id;

    @Expose
    String first_name;

    @Expose
    String last_name;

    @Expose
    String maiden_name;

    @Expose
    String screen_name;

    @Expose
    int sex;

    @Expose
    int relation;

    @Expose
    User relation_partner;

    @Expose
    String bdate;

    @Expose
    int bdate_visibility;

    @Expose
    String home_town;

    @Expose
    String status;

    @Expose
    String phone;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMaiden_name() {
        return maiden_name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public int getSex() {
        return sex;
    }

    public int getRelation() {
        return relation;
    }


    public String getBdate() {
        return bdate;
    }

    public int getBdate_visibility() {
        return bdate_visibility;
    }

    public String getHome_town() {
        return home_town;
    }

    public String getStatus() {
        return status;
    }

    public User getRelation_partner() {
        return relation_partner;
    }

    public String getPhone() {
        return phone;
    }
}
