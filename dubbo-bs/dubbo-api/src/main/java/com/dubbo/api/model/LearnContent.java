package com.dubbo.api.model;

import java.io.Serializable;

public class LearnContent implements Serializable {
    public int id;
    public int iid;
    public String title;
    public String content;
    public int bz;
    public int kc;
    public int sc;
    public String src;
    public String author;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBz() {
        return bz;
    }

    public void setBz(int bz) {
        this.bz = bz;
    }

    public int getKc() {
        return kc;
    }

    public void setKc(int kc) {
        this.kc = kc;
    }

    public int getSc() {
        return sc;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "LearnContent{" +
                "id=" + id +
                ", iid=" + iid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", bz=" + bz +
                ", kc=" + kc +
                ", sc=" + sc +
                ", src='" + src + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
