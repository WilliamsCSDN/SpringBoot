package com.babt.stat.entity;

//电池容量统计数据
public class BatteryCapStat {

	// 总容量
	private double sumCapcity;

	// 剩余容量
	private double sumSurplus;

	// 电池型号
	private String modelName;

	// 平均剩余容量
	private double avgSurplus;
	
	// 电池测试次数
	private int count;

	public BatteryCapStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BatteryCapStat(double sumCapcity, double sumSurplus) {
		super();
		this.sumCapcity = sumCapcity;
		this.sumSurplus = sumSurplus;
	}

	public double getSumCapcity() {
		return sumCapcity;
	}

	public void setSumCapcity(double sumCapcity) {
		this.sumCapcity = sumCapcity;
	}

	public double getSumSurplus() {
		return sumSurplus;
	}

	public void setSumSurplus(double sumSurplus) {
		this.sumSurplus = sumSurplus;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getAvgSurplus() {
		return avgSurplus;
	}

	public void setAvgSurplus(double avgSurplus) {
		this.avgSurplus = avgSurplus;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
