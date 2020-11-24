package com.example.myapplication.Model;

public class User {

    private String id;
    private String username;
    private String fullname;
    private String imageurl;
    private String userreg;
    private String bio;



    public User(String id, String username, String fullname, String imageurl, String bio, String userreg){
        this.id=id;
        this.username=username;
        this.fullname=fullname;
        this.imageurl=imageurl;
        this.userreg=userreg;
        this.bio=bio;

    }
    public User(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserreg() {
        return userreg;
    }

    public void setUserreg(String userreg) {
        this.userreg = userreg;
    }


    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
