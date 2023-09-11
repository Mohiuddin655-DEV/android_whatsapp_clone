package com.whatsapp.whatsapp.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Chat implements Serializable {

    private long time_mills;
    private String date;
    private String time;
    private String id;
    private User user;
    private Object body;
    private Type type;

    public Chat() {
        this.time_mills = System.currentTimeMillis();
        this.date = Provider.toDate(time_mills, "dd-MM-yyyy");
        this.time = Provider.toDate(time_mills, "hh:mm:ss a");
        this.id = String.valueOf(time_mills);
    }

    public Chat build(@NonNull User user, @NonNull Object body, @NonNull Type type) {
        this.user = user;
        this.body = body;
        this.type = type;
        return this;
    }

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

    public User getUser() {
        return user != null ? user : new User();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        MESSAGE,
        VOICE,
        CALL,
        VIDEO,
        PHOTO,
        FILE
    }
}
