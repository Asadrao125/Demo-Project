package com.technado.demoproject.models

class MovieModel {
    public  var title: String = ""
    public  var thumbnailUrl: String = ""

    constructor(ttitle: String, thumbnailUrl: String) {
        this.title = ttitle
        this.thumbnailUrl = thumbnailUrl
    }
}