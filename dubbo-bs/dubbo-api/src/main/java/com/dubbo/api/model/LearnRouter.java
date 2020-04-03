package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class LearnRouter implements Serializable {
    public int id;
    public String name;
    public List<LearnContent> learnContent;

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

    public List<LearnContent> getLearnContent() {
        return learnContent;
    }

    public void setLearnContent(List<LearnContent> learnContent) {
        this.learnContent = learnContent;
    }

    @Override
    public String toString() {
        return "LearnRouter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", learnContent=" + learnContent +
                '}';
    }
}
