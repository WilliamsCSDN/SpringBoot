package com.dubbo.api.model;

import java.io.Serializable;

public class LearnRouter1 implements Serializable {
    public int id;
    public int iid;
    public int searchid;
    public int bz;
    public String name;
    public String title;

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

    public int getSearchid() {
        return searchid;
    }

    public void setSearchid(int searchid) {
        this.searchid = searchid;
    }

    public int getBz() {
        return bz;
    }

    public void setBz(int bz) {
        this.bz = bz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "LearnRouter1{" +
                "id=" + id +
                ", iid=" + iid +
                ", searchid=" + searchid +
                ", bz=" + bz +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
