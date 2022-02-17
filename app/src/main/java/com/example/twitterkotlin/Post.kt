package com.example.twitterkotlin


class Post {
    var profile: Int
    var fullname: String
    var photo = 0
    var photo2 = -1
    var videoUrl: String? = null

    constructor(profile: Int, fullname: String, photo: Int) {
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
    }

    constructor(profile: Int, fullname: String, photo: Int, photo2: Int) {
        this.profile = profile
        this.fullname = fullname
        this.photo = photo
        this.photo2 = photo2
    }

    constructor(profile: Int, fullname: String, videoUrl: String?) {
        this.profile = profile
        this.fullname = fullname
        this.videoUrl = videoUrl
    }
}
