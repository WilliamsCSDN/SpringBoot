package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 二手车按月份统计的地理数据(按省)
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@TableName("babt_st_goe_month_province")
public class BabtStGoeMonthProvince extends Model {

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
	 * 生产厂商
	 */
	private String manufacture;
	/**
	 * 车型id
	 */
	@TableField(value="car_model_id")
	private Long carModelId;
	/**
	 * 车型的名称
	 */
	@TableField(value="car_model_name")
	private String carModelName;
	/**
	 * 平均里程
	 */
	@TableField(value="avg_mile")
	private Double avgMile;
	/**
	 * 车辆数
	 */
	@TableField(value="car_count")
	private Integer carCount;
	/**
	 * 每月的第一天的日期生成上个月的统计数据
	 */
	@TableField(value="first_day_of_month")
	private String firstDayOfMonth;
	/**
	 * 记录生成时间
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 修改时间
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

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
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

	public String getFirstDayOfMonth() {
		return firstDayOfMonth;
	}

	public void setFirstDayOfMonth(String firstDayOfMonth) {
		this.firstDayOfMonth = firstDayOfMonth;
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
