package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class Comment implements Serializable {
    public int comment_id;
    public int articleid;
    public String name;
    public String content;
    public String createtime;
    public int state;
    public List<CommentReply> commentReplyList;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
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

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<CommentReply> getCommentReplyList() {
        return commentReplyList;
    }

    public void setCommentReplyList(List<CommentReply> commentReplyList) {
        this.commentReplyList = commentReplyList;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", articleid=" + articleid +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                ", state=" + state +
                ", commentReplyList=" + commentReplyList +
                '}';
    }
}
