package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@TableName("babt_mc_car")
public class BabtMcCar extends Model<BabtMcCar> {

	private static final long serialVersionUID = 1L;

	/**
	 * 车ID
	 */
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;

	/**
	 * 车型ID
	 */
	@TableField(value="carModelId")
	private Integer carModelId;

	/**
	 * 电池ID
	 */
	private Integer batteryId;

	/**
	 * 车籍/归属地
	 */
	private String area;

	/**
	 * 出厂日期
	 */
	private Date manufactureDate;
	/**
	 * 购车日期
	 */
	private Date buyDatetime;

	/**
	 * 制造商
	 */
	private String bPManufacturer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
	}

	public Integer getBatteryId() {
		return batteryId;
	}

	public void setBatteryId(Integer batteryId) {
		this.batteryId = batteryId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Date getBuyDatetime() {
		return buyDatetime;
	}

	public void setBuyDatetime(Date buyDatetime) {
		this.buyDatetime = buyDatetime;
	}

	public String getbPManufacturer() {
		return bPManufacturer;
	}

	public void setbPManufacturer(String bPManufacturer) {
		this.bPManufacturer = bPManufacturer;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
