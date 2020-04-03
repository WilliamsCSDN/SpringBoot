package com.dubbo.api.model;

import java.io.Serializable;

public class CommentReply implements Serializable {
    public int id;
    public String name;
    public String replyname;
    public String content;
    public int prase_count;
    public String createtime;

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

    public String getReplyname() {
        return replyname;
    }

    public void setReplyname(String replyname) {
        this.replyname = replyname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrase_count() {
        return prase_count;
    }

    public void setPrase_count(int prase_count) {
        this.prase_count = prase_count;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "CommentReply{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", replyname='" + replyname + '\'' +
                ", content='" + content + '\'' +
                ", prase_count=" + prase_count +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
