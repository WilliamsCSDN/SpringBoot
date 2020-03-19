package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtStGoeWeekCity;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
public interface IBabtStGoeWeekCityService extends IService<BabtStGoeWeekCity> {
	
	public  List<BabtStGoeWeekCity>  queryByWeekCity(String provinceCode,String cityCode,int nWeekAgo);
	
}
