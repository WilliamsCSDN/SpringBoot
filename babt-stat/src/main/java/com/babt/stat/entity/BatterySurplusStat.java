package com.babt.stat.entity;

public class BatterySurplusStat {

	// 总的剩余
	private double surplusSum;
	
	// 总的剩余百分比
	private double sohSum;

	// 电池数
	private int batteryCount;
	
	
	

	public BatterySurplusStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getSurplusSum() {
		return surplusSum;
	}

	public void setSurplusSum(double surplusSum) {
		this.surplusSum = surplusSum;
	}

	public double getSohSum() {
		return sohSum;
	}

	public void setSohSum(double sohSum) {
		this.sohSum = sohSum;
	}

	public int getBatteryCount() {
		return batteryCount;
	}

	public void setBatteryCount(int batteryCount) {
		this.batteryCount = batteryCount;
	}

}
