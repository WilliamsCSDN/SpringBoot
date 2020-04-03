package com.dubbo.api.model;

import java.io.Serializable;
import java.util.List;

public class UserKC implements Serializable {
    public int id;
    public int kc;
    public List<Search> search;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKc() {
        return kc;
    }

    public void setKc(int kc) {
        this.kc = kc;
    }

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "UserKC{" +
                "id=" + id +
                ", kc=" + kc +
                ", search=" + search +
                '}';
    }
}
