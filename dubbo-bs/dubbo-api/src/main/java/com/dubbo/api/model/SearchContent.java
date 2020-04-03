package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class SearchContent implements Serializable {
    public int id;
    public int iid;
    public int zj;
    public String title;
    public List<SearchContent1> searchContent1;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SearchContent1> getSearchContent1() {
        return searchContent1;
    }

    public void setSearchContent1(List<SearchContent1> searchContent1) {
        this.searchContent1 = searchContent1;
    }

    @Override
    public String toString() {
        return "SearchContent{" +
                "id=" + id +
                ", iid=" + iid +
                ", zj=" + zj +
                ", title='" + title + '\'' +
                ", searchContent1=" + searchContent1 +
                '}';
    }
}
