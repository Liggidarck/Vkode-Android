package com.george.vkode.network.model.common.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserPhoto {

    @SerializedName("photo_200")
    @Expose
    String photo_200;

    @Expose
    String photo_200_orig;

    @Expose
    String photo_400_orig;

    @Expose
    String photo_50;

    @Expose
    String photo_100;

    public String getPhoto_200() {
        return photo_200;
    }

    public String getPhoto_200_orig() {
        return photo_200_orig;
    }

    public String getPhoto_400_orig() {
        return photo_400_orig;
    }

    public String getPhoto_50() {
        return photo_50;
    }

    public String getPhoto_100() {
        return photo_100;
    }
}
