package com.george.vkode.network.model.friends.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Friends implements Serializable {

    @SerializedName("response")
    @Expose
    FriendsResponse response;

    public FriendsResponse getResponse() {
        return response;
    }
}
