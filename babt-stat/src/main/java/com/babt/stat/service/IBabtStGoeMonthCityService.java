package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtStGoeMonthCity;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
public interface IBabtStGoeMonthCityService extends IService<BabtStGoeMonthCity> {
	public List<BabtStGoeMonthCity>  queryByMonthCity(String provinceCode,String cityCode,int nMonthAgo);
	
}
