package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class UserRouter implements Serializable {
    public int id;
    public int learnrouter;
    public List<LearnContent> learnContent;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLearnrouter() {
        return learnrouter;
    }

    public void setLearnrouter(int learnrouter) {
        this.learnrouter = learnrouter;
    }

    public List<LearnContent> getLearnContent() {
        return learnContent;
    }

    public void setLearnContent(List<LearnContent> learnContent) {
        this.learnContent = learnContent;
    }

    @Override
    public String toString() {
        return "UserRouter{" +
                "id=" + id +
                ", learnrouter=" + learnrouter +
                ", learnContent=" + learnContent +
                '}';
    }
}
