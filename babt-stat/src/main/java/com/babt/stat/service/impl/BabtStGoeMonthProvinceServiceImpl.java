package com.babt.stat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.babt.stat.mapper.BabtStGoeMonthProvinceDao;
import com.babt.stat.service.IBabtStGoeMonthProvinceService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 二手车按月份统计的地理数据(按省)  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@Service
public class BabtStGoeMonthProvinceServiceImpl extends ServiceImpl<BabtStGoeMonthProvinceDao, BabtStGoeMonthProvince> implements IBabtStGoeMonthProvinceService {

	@Override
	public List<BabtStGoeMonthProvince> queryByMonthProvince(String provinceCode, int nMonthAgo) {
		EntityWrapper ew=new EntityWrapper();
		ew.eq("province_code", provinceCode);
		String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(nMonthAgo);
		ew.eq("first_day_of_month", firstDateOfnMonthAgo);
		return baseMapper.selectList(ew);
	}
	
}
