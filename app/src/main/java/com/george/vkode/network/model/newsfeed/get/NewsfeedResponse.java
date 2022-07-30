package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewsfeedResponse implements Serializable {

    @SerializedName("response")
    @Expose
    Newsfeed response;

    public Newsfeed getResponse() {
        return response;
    }
}
