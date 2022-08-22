package com.george.vkode.network.model.common.link;

import com.george.vkode.network.model.common.photo.Photo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("url")
    @Expose
    String url;

    @Expose
    String title;

    @Expose
    String description;

    @Expose
    String target;

    @Expose
    Photo photo;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTarget() {
        return target;
    }

    public Photo getPhoto() {
        return photo;
    }
}
