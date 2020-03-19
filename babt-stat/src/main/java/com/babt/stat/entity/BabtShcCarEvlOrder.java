package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 整车评估委托订单
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@TableName("babt_shc_car_evl_order")
public class BabtShcCarEvlOrder extends Model<BabtShcCarEvlOrder> {

	private static final long serialVersionUID = 1L;

	/**
	 * 评估委托ID
	 */
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	/**
	 * 车ID
	 */
	private Integer carId;
	/**
	 * 电池ID
	 */
	private Integer batteryId;

	/**
	 * 车型ID
	 */
	private Integer carModelId;

	/**
	 * 车籍
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
	
	
	private String ModelName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Integer getBatteryId() {
		return batteryId;
	}

	public void setBatteryId(Integer batteryId) {
		this.batteryId = batteryId;
	}

	public Integer getCarModelId() {
		return carModelId;
	}

	public void setCarModelId(Integer carModelId) {
		this.carModelId = carModelId;
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
	
	
	public String getModelName() {
		return ModelName;
	}

	public void setModelName(String modelName) {
		ModelName = modelName;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
