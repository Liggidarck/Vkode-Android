package com.george.vkode.network.model.common.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoSize {

    @SerializedName("height")
    @Expose
    int height;

    @Expose
    int width;

    @Expose
    String url;

    @Expose
    String type;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String getUrl() {
        return url;
    }

    public String getType() {
        return type;
    }
}
