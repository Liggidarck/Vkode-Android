package com.george.vkode.network.model.newsfeed.get;

import com.george.vkode.network.model.common.photo.Photo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsfeedAttachment {

    @SerializedName("type")
    @Expose
    String type;

    @Expose
    Photo photo;

    public String getType() {
        return type;
    }

    public Photo getPhoto() {
        return photo;
    }
}
