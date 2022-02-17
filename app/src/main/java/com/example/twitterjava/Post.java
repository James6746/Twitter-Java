package com.example.twitterjava;

public class Post {

    private int profile;
    private String fullname;
    private int photo;
    private int photo2 = -1;
    private String videoUrl = null;

    public Post(int profile, String fullname, int photo) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
    }

    public Post(int profile, String fullname, int photo, int photo2) {
        this.profile = profile;
        this.fullname = fullname;
        this.photo = photo;
        this.photo2 = photo2;
    }

    public Post(int profile, String fullname, String videoUrl) {
        this.profile = profile;
        this.fullname = fullname;
        this.videoUrl = videoUrl;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getPhoto2() {
        return photo2;
    }

    public void setPhoto2(int photo2) {
        this.photo2 = photo2;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
