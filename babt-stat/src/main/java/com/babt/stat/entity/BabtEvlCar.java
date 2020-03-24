package com.babt.stat.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;


public class BabtEvlCar {
    private Integer CarModelId;
    private double SOH;

    public Integer getCarModelId() {
        return CarModelId;
    }

    public void setCarModelId(Integer carModelId) {
        CarModelId = carModelId;
    }

    public double getSOH() {
        return SOH;
    }

    public void setSOH(double SOH) {
        this.SOH = SOH;
    }
}
