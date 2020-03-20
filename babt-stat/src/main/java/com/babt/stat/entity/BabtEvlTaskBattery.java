package com.babt.stat.entity;


import java.util.Date;

public class BabtEvlTaskBattery {
    public Integer taskID;
    public Integer batteryID;
    public Date EndTime;
    public Integer CarId;
    public Integer CarModelId;

    public Integer getTaskID() {
        return taskID;
    }

    public void setTaskID(Integer taskID) {
        this.taskID = taskID;
    }

    public Integer getBatteryID() {
        return batteryID;
    }

    public void setBatteryID(Integer batteryID) {
        this.batteryID = batteryID;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public Integer getCarId() {
        return CarId;
    }

    public void setCarId(Integer carId) {
        CarId = carId;
    }

    public Integer getCarModelId() {
        return CarModelId;
    }

    public void setCarModelId(Integer carModelId) {
        CarModelId = carModelId;
    }
}
