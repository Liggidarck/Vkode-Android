package com.george.vkode.network.model.common.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class UserPhotoResponse implements Serializable {

    @SerializedName("response")
    @Expose
    List<UserPhoto> response;

    public List<UserPhoto> getResponse() {
        return response;
    }
}
