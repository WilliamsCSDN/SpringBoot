package com.babt.stat.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 每周平均评估耗时
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-07
 */
@TableName("babt_st_avg_eval_time_consumer")
public class BabtStAvgEvalTimeConsumer extends Model<BabtStAvgEvalTimeConsumer> {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 评估耗时(单位分钟)
	 */
	@TableField(value="avg_time_consumer")
	private Integer avgTimeConsumer;
	/**
	 * 周一的日期
	 */
	@TableField(value="monday_op")
	private String mondayOp;
	/**
	 * 记录生成时间
	 */
	@TableField(value="create_time")
	private Date createTime;
	/**
	 * 记录修改时间
	 */
	@TableField(value="update_time")
	private Date updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAvgTimeConsumer() {
		return avgTimeConsumer;
	}

	public void setAvgTimeConsumer(Integer avgTimeConsumer) {
		this.avgTimeConsumer = avgTimeConsumer;
	}

	public String getMondayOp() {
		return mondayOp;
	}

	public void setMondayOp(String mondayOp) {
		this.mondayOp = mondayOp;
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

}
