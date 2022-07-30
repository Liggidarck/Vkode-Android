package com.george.vkode.network.model.account.profileInfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ProfileInfoResponse implements Serializable {

    @SerializedName("response")
    @Expose
    ProfileInfo response;

    public ProfileInfo getResponse() {
        return response;
    }
}
