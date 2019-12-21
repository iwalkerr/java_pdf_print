package com.greejoy.model;

public class Todo {
    public int id;
    public String appId;

    public Todo(int id, String appId) {
        this.id = id;
        this.appId = appId;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


}
