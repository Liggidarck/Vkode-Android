package com.george.vkode.network.model.newsfeed.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsfeedItem {

    @SerializedName("post_id")
    @Expose
    int post_id;

    @Expose
    String type;

    @Expose
    int source_id;

    @Expose
    int date;

    @Expose
    boolean can_doubt_category;

    @Expose
    boolean can_set_category;

    @Expose
    int id;

    @Expose
    int owner_id;

    @Expose
    boolean is_favorite;

    @Expose
    String post_type;

    @Expose
    String text;

    @Expose
    int signer_id;

    @Expose
    int marked_as_ads;

    @Expose
    List<NewsfeedAttachment> attachments;

    @Expose
    NewsfeedComments comments;

    @Expose
    NewsfeedLikes likes;

    @Expose
    NewsfeedReposts reposts;

    @Expose
    NewsfeedViews views;

    public int getPost_id() {
        return post_id;
    }

    public String getType() {
        return type;
    }

    public int getSource_id() {
        return source_id;
    }

    public int getDate() {
        return date;
    }

    public boolean isCan_doubt_category() {
        return can_doubt_category;
    }

    public boolean isCan_set_category() {
        return can_set_category;
    }

    public int getId() {
        return id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public String getPost_type() {
        return post_type;
    }

    public String getText() {
        return text;
    }

    public int getSigner_id() {
        return signer_id;
    }

    public int getMarked_as_ads() {
        return marked_as_ads;
    }

    public List<NewsfeedAttachment> getAttachments() {
        return attachments;
    }

    public NewsfeedComments getComments() {
        return comments;
    }

    public NewsfeedLikes getLikes() {
        return likes;
    }

    public NewsfeedReposts getReposts() {
        return reposts;
    }

    public NewsfeedViews getViews() {
        return views;
    }
}
