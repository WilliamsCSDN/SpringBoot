package com.babt.stat.entity.cond;

import java.util.Date;

public class Car4StatCond {

	// 车模型ID
	private long carModelId;

	// 厂商
	private String bPManufacturer;

	// 地区
	private String area;

	// 查询开始时间
	private Date startTime;

	// 查询结束时间
	private Date endTime;

	public Car4StatCond() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Car4StatCond(long carModelId, String bPManufacturer, String area, Date startTime, Date endTime) {
		this.carModelId = carModelId;
		this.bPManufacturer = bPManufacturer;
		this.area = area;
		this.startTime = startTime;
		this.endTime = endTime;
	}




	public long getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(long carModelId) {
		this.carModelId = carModelId;
	}

	public String getbPManufacturer() {
		return bPManufacturer;
	}

	public void setbPManufacturer(String bPManufacturer) {
		this.bPManufacturer = bPManufacturer;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
