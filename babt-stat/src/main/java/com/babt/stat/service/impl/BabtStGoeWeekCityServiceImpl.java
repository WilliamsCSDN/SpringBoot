package com.babt.stat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.entity.BabtStGoeWeekCity;
import com.babt.stat.mapper.BabtStGoeWeekCityDao;
import com.babt.stat.service.IBabtStGoeWeekCityService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 二手车按周统计地理数据(按城市)  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@Service
public class BabtStGoeWeekCityServiceImpl extends ServiceImpl<BabtStGoeWeekCityDao, BabtStGoeWeekCity> implements IBabtStGoeWeekCityService {

	@Override
	public List<BabtStGoeWeekCity> queryByWeekCity(String provinceCode, String cityCode, int nWeekAgo) {
		String mondayOfnWeekAgo=BabtDateUtil.nWeekAgoMonday0(nWeekAgo);
		EntityWrapper ew=new EntityWrapper();
		ew.eq("province_code", provinceCode);
		ew.eq("city_code", cityCode);
		ew.eq("monday_date", mondayOfnWeekAgo);
		return baseMapper.selectList(ew);
	
	}
}
