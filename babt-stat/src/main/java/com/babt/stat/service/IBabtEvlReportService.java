package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtEvlReport;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface IBabtEvlReportService extends IService<BabtEvlReport> {
	public List<BabtEvlReport> queryBabtEvlReport();

}
