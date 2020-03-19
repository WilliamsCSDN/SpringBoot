package com.babt.stat.service.impl;

import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.babt.stat.mapper.BabtStGoeMonthDistrictDao;
import com.babt.stat.service.IBabtStGoeMonthDistrictService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 二手车按月份统计的地理数据(按区)  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@Service
public class BabtStGoeMonthDistrictServiceImpl extends ServiceImpl<BabtStGoeMonthDistrictDao, BabtStGoeMonthDistrict> implements IBabtStGoeMonthDistrictService {

	@Override
	public List<BabtStGoeMonthDistrict> queryByMonthDistrict(String provinceCode, String cityCode, String districtCode, int nMonthAgo) {
		EntityWrapper ew=new EntityWrapper();
		ew.eq("province_code", provinceCode);
		ew.eq("city_code", cityCode);
		ew.eq("district_code", districtCode);
		String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(nMonthAgo);
		ew.eq("first_day_of_month", firstDateOfnMonthAgo);
		return baseMapper.selectList(ew);
	}
	
}
