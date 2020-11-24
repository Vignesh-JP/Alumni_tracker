package com.example.myapplication.Model;

public class Post {
    private String postid;
    private String postimage;
    private String descriptionpost;
    private String publisher;

    public Post(String postid, String postimage, String descriptionpost, String publisher) {
        this.postid = postid;
        this.postimage = postimage;
        this.descriptionpost = descriptionpost;
        this.publisher = publisher;
    }

    public Post() {
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getPostimage() {
        return postimage;
    }

    public void setPostimage(String postimage) {
        this.postimage = postimage;
    }

    public String getDescriptionpost() {
        return descriptionpost;
    }

    public void setDescriptionpost(String descriptionpost) {
        this.descriptionpost = descriptionpost;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}


