package com.babt.stat.mapper;

import java.util.List;

import com.babt.stat.entity.BabtEvlReport;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface BabtEvlReportDao extends BaseMapper<BabtEvlReport> {
	public List<BabtEvlReport> queryBabtEvlReport();

}
