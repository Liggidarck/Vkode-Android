package com.george.vkode.network.model.account.info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("country")
    @Expose
    String country;

    @Expose
    int https_required;

    @Expose
    int fa_required;

    @Expose
    int own_posts_default;

    @Expose
    int no_wall_replies;

    @Expose
    int lang;

    public String getCountry() {
        return country;
    }

    public int getHttps_required() {
        return https_required;
    }

    public int getFa_required() {
        return fa_required;
    }

    public int getOwn_posts_default() {
        return own_posts_default;
    }

    public int getNo_wall_replies() {
        return no_wall_replies;
    }

    public int getLang() {
        return lang;
    }
}
