package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class WenDa implements Serializable {
    public int id;
    public String question;
    public String content;
    public String author;
    public String createtime;
    public int countwenda;
    public List<WenDaComment> wenDaComment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public List<WenDaComment> getWenDaComment() {
        return wenDaComment;
    }

    public void setWenDaComment(List<WenDaComment> wenDaComment) {
        this.wenDaComment = wenDaComment;
    }

    public int getCountwenda() {
        return countwenda;
    }

    public void setCountwenda(int countwenda) {
        this.countwenda = countwenda;
    }

    @Override
    public String toString() {
        return "WenDa{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createtime='" + createtime + '\'' +
                ", countwenda=" + countwenda +
                ", wenDaComment=" + wenDaComment +
                '}';
    }
}
