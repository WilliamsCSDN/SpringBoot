package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
public interface IBabtStGoeMonthDistrictService extends IService<BabtStGoeMonthDistrict> {
	public  List<BabtStGoeMonthDistrict>  queryByMonthDistrict(String provinceCode,String cityCode,String districtCode,int nMonthAgo);
	
}
