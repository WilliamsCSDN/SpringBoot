package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author denglianyong
 * @since 2018-04-06
 */
@TableName("babt_evl_task")
public class BabtEvlTask extends Model<BabtEvlTask> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 评估任务名称
     */
    private String Name;
    /**
     * 电池评估记录ID：null-手动创建，非空-二手车电池自动评估创建
     */
    private Integer recordId;
	/**
	 * 评估对象类型: 1-车辆，2-电池
	 */
	private Integer objectType;
    /**
     * 车辆ID
     */
    private Integer carId;
	/**
	 * 电池ID
	 */
	private Integer BatteryId;
	/**
	 * 评估任务创建时间
	 */
    private Date createTime;
    /**
     * 评估任务开始执行时间
     */
    private Date startTime;
    /**
     * 评估结束时间
     */
    private Date endTime;
    /**
     * 任务执行状态：1-草稿、2-等待、3-评估中、4-完成、5-评估失败
     */
    private Integer status;

	/**
	 * 评估模型ID
	 */
	private Integer modelID;
	/**
	 * 算法ID
	 */
	private Integer algId;
	/**
	 * 0完成，整数为完成当前步骤；
	 */
	private Integer guideSteps;
	/**
	 * 备份的评估数据
	 */
	private String evaluationDataBck;
	/**
	 * 创建者（管理员）
	 */
	private Integer creator;
	/**
	 * 车型ID
	 */
	private Integer carModleId;
	/**
	 * 电池型号ID
	 */
	private Integer batteryModelId;
	/**
	 * 测试数据
	 */
	private Integer testDataId;
	/**
	 * 监控数据
	 */
	private Integer runDataId;
	/**
	 * 评估类型
	 */
	private Integer evaluationType;
	/**
	 * 车辆原始数据
	 */
	private Integer carRawDataId;
  


    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCarModleId() {
		return carModleId;
	}
	public void setCarModleId(Integer carModleId) {
		this.carModleId = carModleId;
	}
	@Override
    protected Serializable pkVal() {
        return this.id;
    }

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getObjectType() {
		return objectType;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	public Integer getBatteryId() {
		return BatteryId;
	}

	public void setBatteryId(Integer batteryId) {
		BatteryId = batteryId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getModelID() {
		return modelID;
	}

	public void setModelID(Integer modelID) {
		this.modelID = modelID;
	}

	public Integer getAlgId() {
		return algId;
	}

	public void setAlgId(Integer algId) {
		this.algId = algId;
	}

	public Integer getGuideSteps() {
		return guideSteps;
	}

	public void setGuideSteps(Integer guideSteps) {
		this.guideSteps = guideSteps;
	}

	public String getEvaluationDataBck() {
		return evaluationDataBck;
	}

	public void setEvaluationDataBck(String evaluationDataBck) {
		this.evaluationDataBck = evaluationDataBck;
	}

	public Integer getCreator() {
		return creator;
	}

	public void setCreator(Integer creator) {
		this.creator = creator;
	}

	public Integer getBatteryModelId() {
		return batteryModelId;
	}

	public void setBatteryModelId(Integer batteryModelId) {
		this.batteryModelId = batteryModelId;
	}

	public Integer getTestDataId() {
		return testDataId;
	}

	public void setTestDataId(Integer testDataId) {
		this.testDataId = testDataId;
	}

	public Integer getRunDataId() {
		return runDataId;
	}

	public void setRunDataId(Integer runDataId) {
		this.runDataId = runDataId;
	}

	public Integer getEvaluationType() {
		return evaluationType;
	}

	public void setEvaluationType(Integer evaluationType) {
		this.evaluationType = evaluationType;
	}

	public Integer getCarRawDataId() {
		return carRawDataId;
	}

	public void setCarRawDataId(Integer carRawDataId) {
		this.carRawDataId = carRawDataId;
	}
}
