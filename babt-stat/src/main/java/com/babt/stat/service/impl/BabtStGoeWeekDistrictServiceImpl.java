package com.babt.stat.service.impl;

import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.babt.stat.mapper.BabtStGoeWeekDistrictDao;
import com.babt.stat.service.IBabtStGoeWeekDistrictService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 二手车按周统计地理数据(按区) 服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-15
 */
@Service
public class BabtStGoeWeekDistrictServiceImpl extends ServiceImpl<BabtStGoeWeekDistrictDao, BabtStGoeWeekDistrict>
		implements IBabtStGoeWeekDistrictService {

	@Override
	public List<BabtStGoeWeekDistrict> queryByWeekDistrict(String provinceCode, String cityCode, String districtCode, int nWeekAgo) {
		String mondayOfnWeekAgo = BabtDateUtil.nWeekAgoMonday0(nWeekAgo);
		EntityWrapper ew = new EntityWrapper();
		ew.eq("province_code", provinceCode);
		ew.eq("city_code", cityCode);
		ew.eq("district_code", districtCode);
		ew.eq("monday_date", mondayOfnWeekAgo);
		return baseMapper.selectList(ew);

	}

}
