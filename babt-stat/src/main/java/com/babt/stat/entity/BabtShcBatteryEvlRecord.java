package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 电池评估记录
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@TableName("babt_shc_battery_evl_record")
public class BabtShcBatteryEvlRecord extends Model<BabtShcBatteryEvlRecord> {

	private static final long serialVersionUID = 1L;

	/**
	 * 电池评估记录ID
	 */
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	/**
	 * 评估委托ID
	 */
	private Integer orderId;

	/**
	 * 电池id
	 */
	private Integer batteryId;

	
	
	private Integer completed;

	/**
	 * 评估日期
	 */
	private Date evlDate;

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBatteryId() {
		return batteryId;
	}

	public void setBatteryId(Integer batteryId) {
		this.batteryId = batteryId;
	}

	public Integer getCompleted() {
		return completed;
	}

	public void setCompleted(Integer completed) {
		this.completed = completed;
	}

	public Date getEvlDate() {
		return evlDate;
	}

	public void setEvlDate(Date evlDate) {
		this.evlDate = evlDate;
	}

}
