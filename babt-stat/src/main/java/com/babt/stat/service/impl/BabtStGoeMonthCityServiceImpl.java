package com.babt.stat.service.impl;

import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.mapper.BabtStGoeMonthCityDao;
import com.babt.stat.service.IBabtStGoeMonthCityService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 二手车按月份统计的地理数据(按城市)  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@Service
public class BabtStGoeMonthCityServiceImpl extends ServiceImpl<BabtStGoeMonthCityDao, BabtStGoeMonthCity> implements IBabtStGoeMonthCityService {

	@Override
	public List<BabtStGoeMonthCity> queryByMonthCity(String provinceCode,String cityCode, int nMonthAgo) {
		EntityWrapper ew=new EntityWrapper();
		ew.eq("province_code", provinceCode);
		ew.eq("city_code", cityCode);
		String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(nMonthAgo);
		ew.eq("first_day_of_month", firstDateOfnMonthAgo);
		return baseMapper.selectList(ew);
	}
	
}
