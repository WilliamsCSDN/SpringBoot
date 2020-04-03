package com.dubbo.api.model;

import java.io.Serializable;

public class SearchContent1 implements Serializable {
    public int id;
    public int iid;
    public int zj;
    public String zjj;
    public String title;
    public String url;

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

    public int getZj() {
        return zj;
    }

    public void setZj(int zj) {
        this.zj = zj;
    }

    public String getZjj() {
        return zjj;
    }

    public void setZjj(String zjj) {
        this.zjj = zjj;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SearchContent1{" +
                "id=" + id +
                ", iid=" + iid +
                ", zj=" + zj +
                ", zjj='" + zjj + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
