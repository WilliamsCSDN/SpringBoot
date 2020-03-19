package com.babt.stat.entity.cond;

import java.util.Date;

public class PcdMonthCond {

	private String provinceCode;

	private String cityCode;

	private String districtCode;

	private Date startTime;

	private Date endTime;

	public PcdMonthCond(String provinceCode, Date startTime, Date endTime) {
		super();
		this.provinceCode = provinceCode;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public PcdMonthCond() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
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

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

}
