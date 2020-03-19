package com.babt.stat.service.impl;

import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.babt.stat.mapper.BabtStGoeWeekProvinceDao;
import com.babt.stat.service.IBabtStGoeWeekProvinceService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 二手车按周统计地理数据(按省)  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@Service
public class BabtStGoeWeekProvinceServiceImpl extends ServiceImpl<BabtStGoeWeekProvinceDao, BabtStGoeWeekProvince> implements IBabtStGoeWeekProvinceService {

	@Override
	public List<BabtStGoeWeekProvince> queryByWeekProvince(String provinceCode, int nWeekAgo) {
		String mondayOfnWeekAgo=BabtDateUtil.nWeekAgoMonday0(nWeekAgo);
		EntityWrapper ew=new EntityWrapper();
		ew.eq("province_code", provinceCode);
		ew.eq("monday_date", mondayOfnWeekAgo);
		return baseMapper.selectList(ew);
	}
	
}
