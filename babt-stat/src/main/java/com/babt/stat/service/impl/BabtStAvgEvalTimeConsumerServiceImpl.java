package com.babt.stat.service.impl;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtStAvgEvalTimeConsumer;
import com.babt.stat.mapper.BabtStAvgEvalTimeConsumerDao;
import com.babt.stat.service.IBabtStAvgEvalTimeConsumerService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 每周平均评估耗时  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-07
 */
@Service
public class BabtStAvgEvalTimeConsumerServiceImpl extends ServiceImpl<BabtStAvgEvalTimeConsumerDao, BabtStAvgEvalTimeConsumer> implements IBabtStAvgEvalTimeConsumerService {

	@Override
	public boolean isExistOneWeekAgo(String monday) {
		
		return baseMapper.countDataOneWeekAgo(monday)>0;
	}

	@Override
	public BabtStAvgEvalTimeConsumer queryNweekAgo(int n) {
		String monday= BabtDateUtil.nWeekAgoMonday0(n);
		BabtStAvgEvalTimeConsumer data= baseMapper.queryByMonday(monday);
		if(data==null){
			System.out.println("================queryNweekAgo   monday="+monday+";data is null   ");
		}else{
			System.out.println("================queryNweekAgo   monday="+monday+";data  avgTime="+data.getAvgTimeConsumer());
		}
		
		return data;
	}
	
}
