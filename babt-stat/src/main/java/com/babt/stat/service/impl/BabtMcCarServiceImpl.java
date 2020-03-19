package com.babt.stat.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtMcCar;
import com.babt.stat.mapper.BabtMcCarDao;
import com.babt.stat.service.IBabtMcCarService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@Service
public class BabtMcCarServiceImpl extends ServiceImpl<BabtMcCarDao, BabtMcCar> implements IBabtMcCarService {
	
	
	// 统计平均每周评估耗时
	public int avgEvalTimeConsumer(Date startDate,Date endDate){
		
		return 0;
	}
	
	
}
