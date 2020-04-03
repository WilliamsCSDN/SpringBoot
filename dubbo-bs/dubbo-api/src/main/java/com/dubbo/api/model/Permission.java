package com.dubbo.api.model;

import java.io.Serializable;

public class Permission implements Serializable {
    public int id;
    public int iid;
    public String permission;

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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", iid=" + iid +
                ", permission='" + permission + '\'' +
                '}';
    }
}
