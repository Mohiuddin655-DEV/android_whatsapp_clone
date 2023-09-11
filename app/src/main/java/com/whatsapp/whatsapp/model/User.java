package com.whatsapp.whatsapp.model;

import java.io.Serializable;

public class User implements Serializable {

    private long time_mills;

    private String date;
    private String time;
    private String id;
    private String name;
    private String full_name;
    private String photo;

    public long getTime_mills() {
        return time_mills;
    }

    public void setTime_mills(long time_mills) {
        this.time_mills = time_mills;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
