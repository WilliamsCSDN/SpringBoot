package com.dubbo.api.model;

import java.io.Serializable;


public class Content implements Serializable {
    public int id;
    public int iid;
    public String name;
    public String href;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", iid=" + iid +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
