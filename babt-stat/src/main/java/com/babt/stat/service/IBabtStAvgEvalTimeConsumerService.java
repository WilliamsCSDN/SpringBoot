package com.babt.stat.service;

import com.babt.stat.entity.BabtStAvgEvalTimeConsumer;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-07
 */
public interface IBabtStAvgEvalTimeConsumerService extends IService<BabtStAvgEvalTimeConsumer> {
	
	public boolean isExistOneWeekAgo(String monday) ;
	
	public BabtStAvgEvalTimeConsumer queryNweekAgo(int n);
	
}
