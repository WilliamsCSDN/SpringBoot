package com.babt.stat.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@TableName("babt_evl_report")
public class BabtEvlReport extends Model<BabtEvlReport> {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	/**
	 * 评估任务ID
	 */
	private Integer taskId;
	/**
	 * 预测SOC
	 */
	private double soc;
	/**
	 * 车辆运行时间
	 */
	private String totalTime;
	/**
	 * 电池包绝缘性
	 */
	private String barrier;
	/**
	 * 电池压差
	 */
	private String voltageDelta;
	/**
	 * 车辆已行驶总里程ODO
	 */
	private String odo;
	/**
	 * 预测SOH
	 */
	private double soh;
	private String chargeLift;
	/**
	 * 维修建议
	 */
	private String repairSugesstion;
	/**
	 * 备注
	 */
	private String discription;
	/**
	 * 前期使用区域
	 */
	private String area;
	/**
	 * 评估准确率
	 */
	private String accuracy;

	public Integer getId() {
		return id;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public double getSoc() {
		return soc;
	}

	public void setSoc(double soc) {
		this.soc = soc;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public String getBarrier() {
		return barrier;
	}

	public void setBarrier(String barrier) {
		this.barrier = barrier;
	}

	public String getVoltageDelta() {
		return voltageDelta;
	}

	public void setVoltageDelta(String voltageDelta) {
		this.voltageDelta = voltageDelta;
	}

	public String getOdo() {
		return odo;
	}

	public void setOdo(String odo) {
		this.odo = odo;
	}

	public double getSoh() {
		return soh;
	}

	public void setSoh(double soh) {
		this.soh = soh;
	}

	public String getChargeLift() {
		return chargeLift;
	}

	public void setChargeLift(String chargeLift) {
		this.chargeLift = chargeLift;
	}

	public String getRepairSugesstion() {
		return repairSugesstion;
	}

	public void setRepairSugesstion(String repairSugesstion) {
		this.repairSugesstion = repairSugesstion;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
}
