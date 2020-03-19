package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
public interface IBabtStGoeWeekDistrictService extends IService<BabtStGoeWeekDistrict> {
	public  List<BabtStGoeWeekDistrict>  queryByWeekDistrict(String provinceCode,String cityCode,String districtCode,int nWeekAgo);
	
}
