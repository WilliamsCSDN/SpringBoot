package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class WenDaComment implements Serializable {
    public int id;
    public int iid;
    public String name;
    public String content;
    public List<WenDaReply> wenDaReply;

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<WenDaReply> getWenDaReply() {
        return wenDaReply;
    }

    public void setWenDaReply(List<WenDaReply> wenDaReply) {
        this.wenDaReply = wenDaReply;
    }

    @Override
    public String toString() {
        return "WenDaComment{" +
                "id=" + id +
                ", iid=" + iid +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", wenDaReply=" + wenDaReply +
                '}';
    }
}
