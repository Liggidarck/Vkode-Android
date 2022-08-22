package com.george.vkode.network.model.common.photo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @SerializedName("album_id")
    @Expose
    int album_id;

    @Expose
    int date;

    @Expose
    int id;

    @Expose
    int owner_id;

    @Expose
    String access_key;

    @Expose
    List<PhotoSize> sizes;

    public int getAlbum_id() {
        return album_id;
    }

    public int getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public String getAccess_key() {
        return access_key;
    }

    public List<PhotoSize> getSizes() {
        return sizes;
    }
}
