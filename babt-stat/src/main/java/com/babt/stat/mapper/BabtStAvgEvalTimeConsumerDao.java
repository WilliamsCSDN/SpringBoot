package com.babt.stat.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.babt.stat.entity.BabtStAvgEvalTimeConsumer;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-07
 */
public interface BabtStAvgEvalTimeConsumerDao extends BaseMapper<BabtStAvgEvalTimeConsumer> {
	
	@Select("select count(id) from babt_st_avg_eval_time_consumer where monday_op=#{monday}")
	 int countDataOneWeekAgo(@Param("monday") String monday);
	
	
	@Select("select id as Id,avg_time_consumer as avgTimeConsumer,monday_op as mondayOp from babt_st_avg_eval_time_consumer where monday_op=#{monday}")
	public BabtStAvgEvalTimeConsumer queryByMonday(@Param("monday") String monday);

}