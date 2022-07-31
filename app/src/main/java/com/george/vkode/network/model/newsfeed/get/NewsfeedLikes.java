package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsfeedLikes {

    @SerializedName("can_like")
    @Expose
    int can_like;

    @Expose
    int count;

    @Expose
    int user_likes;

    @Expose
    int can_publish;

    public int getCan_like() {
        return can_like;
    }

    public int getCount() {
        return count;
    }

    public int getUser_likes() {
        return user_likes;
    }

    public int getCan_publish() {
        return can_publish;
    }
}
