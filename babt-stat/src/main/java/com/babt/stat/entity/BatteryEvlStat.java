package com.babt.stat.entity;

// 二手电池数量统计
public class BatteryEvlStat {

	private String area;

	private int count;

	private String month;

	private String modelName;

	public BatteryEvlStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BatteryEvlStat(String area, int count) {
		super();
		this.area = area;
		this.count = count;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}
