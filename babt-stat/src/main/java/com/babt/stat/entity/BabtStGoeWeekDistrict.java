package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 二手车按周统计地理数据(按区)
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@TableName("babt_st_goe_week_district")
public class BabtStGoeWeekDistrict extends Model {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 省
	 */
	@TableField(value="province_code")
	private String provinceCode;
	/**
	 * 市
	 */
	@TableField(value="city_code")
	private String cityCode;
	/**
	 * 区
	 */
	@TableField(value="district_code")
	private String districtCode;
	/**
	 * 汽车生产厂商
	 */
	private String manufacturer;
	/**
	 * 车型id
	 */
	@TableField(value="car_model_id")
	private Long carModelId;
	/**
	 * 车型名称
	 */
	@TableField(value="car_model_name")
	private String carModelName;
	/**
	 * 平均里程
	 */
	@TableField(value="avg_mile")
	private Double avgMile;
	/**
	 * 汽车数量
	 */
	@TableField(value="car_count")
	private Integer carCount;
	/**
	 * 
	 */
	@TableField(value="monday_date")
	private String mondayDate;
	/**
	 * 
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 
	 */
	@TableField(value="update_time")
	private Date updateTime;

	private double longitude;
	
	private double latitude;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
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

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(Long carModelId) {
		this.carModelId = carModelId;
	}

	public String getCarModelName() {
		return carModelName;
	}

	public void setCarModelName(String carModelName) {
		this.carModelName = carModelName;
	}

	public Double getAvgMile() {
		return avgMile;
	}

	public void setAvgMile(Double avgMile) {
		this.avgMile = avgMile;
	}

	public Integer getCarCount() {
		return carCount;
	}

	public void setCarCount(Integer carCount) {
		this.carCount = carCount;
	}

	public String getMondayDate() {
		return mondayDate;
	}

	public void setMondayDate(String mondayDate) {
		this.mondayDate = mondayDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
