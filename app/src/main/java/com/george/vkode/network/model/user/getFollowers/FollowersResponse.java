package com.george.vkode.network.model.user.getFollowers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FollowersResponse implements Serializable {

    @SerializedName("response")
    @Expose
    Followers response;

    public Followers getResponse() {
        return response;
    }
}
