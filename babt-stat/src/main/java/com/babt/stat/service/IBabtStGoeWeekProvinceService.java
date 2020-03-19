package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
public interface IBabtStGoeWeekProvinceService extends IService<BabtStGoeWeekProvince> {
	
	public  List<BabtStGoeWeekProvince>  queryByWeekProvince(String provinceCode,int nWeekAgo);
	
}
