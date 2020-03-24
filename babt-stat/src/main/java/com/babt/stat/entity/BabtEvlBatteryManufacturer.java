package com.babt.stat.entity;

public class BabtEvlBatteryManufacturer {
    private String BatteryManufacturer;
    private Double SOH;

    public String getBatteryManufacturer() {
        return BatteryManufacturer;
    }

    public void setBatteryManufacturer(String batteryManufacturer) {
        BatteryManufacturer = batteryManufacturer;
    }

    public Double getSOH() {
        return SOH;
    }

    public void setSOH(Double SOH) {
        this.SOH = SOH;
    }
}
