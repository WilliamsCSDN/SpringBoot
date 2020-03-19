package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
public interface IBabtStGoeMonthProvinceService extends IService<BabtStGoeMonthProvince> {
	
	public  List<BabtStGoeMonthProvince>  queryByMonthProvince(String provinceCode,int nMonthAgo);


	
}
