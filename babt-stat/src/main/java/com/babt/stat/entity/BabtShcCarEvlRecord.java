package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 整车评估记录
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@TableName("babt_shc_car_evl_record")
public class BabtShcCarEvlRecord extends Model<BabtShcCarEvlRecord> {

	private static final long serialVersionUID = 1L;

	/**
	 * 整车评估记录ID
	 */
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	/**
	 * 评估委托ID
	 */
	private Integer orderId;
	/**
	 * 是否完成，1-未开始，2-进行中，3-已完成
	 */
	private Integer completed;

	/**
	 * 评估日期
	 */
	private Date evlDate;

	/**
	 * 完成日期
	 */
	private Date completeDate;

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

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}