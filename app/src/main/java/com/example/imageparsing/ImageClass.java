package com.example.imageparsing;

public class ImageClass {
    String url;
    String thumbnailUrl;
    String title;

    public ImageClass(String url, String thumbnailUrl, String title) {
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
