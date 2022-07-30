package com.george.vkode.network.model.account.info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InfoResponse implements Serializable {

    @SerializedName("response")
    @Expose
    Info response;

    public Info getResponse() {
        return response;
    }
}
