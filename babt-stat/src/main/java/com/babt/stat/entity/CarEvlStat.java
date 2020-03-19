package com.babt.stat.entity;

// 汽车评估统计表
public class CarEvlStat {

	// 车型
	private String modelName;
	
	// 地区
	private String area;

	// 数量
	private int count;

	// 平均电池剩余容量
	private double avgSurplusCap;

	// 车龄，单位月
	private int age;
	
	//月份
	private int month;
	
	//第几周
	private String week;
	
	//评估用了几分钟
	private int minutes;
	
	
	// 按地区统计平均里程
	private double avgMileage;

	public CarEvlStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

	public double getAvgSurplusCap() {
		return avgSurplusCap;
	}

	public void setAvgSurplusCap(double avgSurplusCap) {
		this.avgSurplusCap = avgSurplusCap;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public double getAvgMileage() {
		return avgMileage;
	}

	public void setAvgMileage(double avgMileage) {
		this.avgMileage = avgMileage;
	}

	
}
