package com.example.twitterjava;

public class Story {
    private int profile;
    private String fullname;

    public Story(int profile, String fullname) {
        this.profile = profile;
        this.fullname = fullname;
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
}
