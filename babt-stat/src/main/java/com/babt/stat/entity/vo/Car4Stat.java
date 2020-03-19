package com.babt.stat.entity.vo;

import java.util.HashMap;
import java.util.Map;

import com.babt.stat.entity.cond.Car4StatCond;

public class Car4Stat {

	public Map<String, String> data = new HashMap<String, String>();

	private Car4StatCond cond;

	public Car4Stat(Integer carCount, Double avgRate, Double avgAge,Double avgMile) {
		super();
		setCarCount(carCount);
		setAvgRate(avgRate);
		setAvgAge(avgAge);
		setAvgMile(avgMile);
	}

	public void setCarCount(Integer carCount) {
		data.put("carCount", "" + carCount);
	}

	public void setAvgRate(Double avgRate) {
		data.put("avgRate", "" + avgRate);
	}

	public void setAvgAge(Double avgAge) {
		data.put("avgAge", "" + avgAge);
	}

	public void setAvgMile(Double avgMile) {
		data.put("avgMile", "" + avgMile);
	}

	public Car4StatCond getCond() {
		return cond;
	}

	public void setCond(Car4StatCond cond) {
		this.cond = cond;
	}

}
