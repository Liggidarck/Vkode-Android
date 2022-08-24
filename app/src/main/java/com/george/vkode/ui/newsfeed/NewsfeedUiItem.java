package com.george.vkode.ui.newsfeed;

public class NewsfeedUiItem {

    String title;
    String text;
    String photo;
    int day;
    String moth;
    String time;
    String photoPost;

    public NewsfeedUiItem(String title, String text, String photo, int day, String moth, String time, String photoPost) {
        this.title = title;
        this.text = text;
        this.photo = photo;
        this.day = day;
        this.moth = moth;
        this.time = time;
        this.photoPost = photoPost;
    }

    public String getPhotoPost() {
        return photoPost;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getPhoto() {
        return photo;
    }

    public int getDay() {
        return day;
    }

    public String getMoth() {
        return moth;
    }

    public String getTime() {
        return time;
    }
}
