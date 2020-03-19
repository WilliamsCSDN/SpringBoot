package com.babt.stat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtAreaCode;
import com.babt.stat.entity.BabtShcCarEvlOrder;
import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.babt.stat.entity.BabtStGoeWeekCity;
import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.babt.stat.entity.cond.PcdMonthCond;
import com.babt.stat.mapper.BabtShcCarEvlOrderDao;
import com.babt.stat.service.IBabtShcCarEvlOrderService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 整车评估委托订单 服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@Service
public class BabtShcCarEvlOrderServiceImpl extends ServiceImpl<BabtShcCarEvlOrderDao, BabtShcCarEvlOrder> implements IBabtShcCarEvlOrderService {

	@Override
	public List<BabtAreaCode> queryAllProvince() {
		return baseMapper.queryAllProvince();
	}

	@Override
	public List<BabtAreaCode> queryAllCity() {
		return baseMapper.queryAllCity();
	}

	@Override
	public List<BabtAreaCode> queryAllDistrict() {
		return baseMapper.queryAllDistrict();
	}

	@Override
	public BabtStGoeMonthProvince query1MonthAgoByProvince(String provinceCode) {
		Date startTime=BabtDateUtil.obtainFirstDay0OfnMonth(0);
		Date endTime=BabtDateUtil.obtainLastDay24OfnMonth(0);
		//int provinceCode=Integer.parseInt(provinceCodes);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeMonthProvince(cond);
	}

	@Override
	public BabtStGoeMonthProvince queryNMonthAgoByProvince(String provinceCode, int nMonthAgo) {
		Date startTime=BabtDateUtil.obtainFirstDay0OfnMonth(nMonthAgo);
		Date endTime=BabtDateUtil.obtainLastDay24OfnMonth(nMonthAgo);
		//int provinceCode=Integer.parseInt(provinceCodes);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeMonthProvince(cond);
	}

	@Override
	public BabtStGoeMonthCity query1MonthAgoByCity(String provinceCode, String cityCode) {
		Date startTime=BabtDateUtil.obtainFirstDay0OfnMonth(0);
		Date endTime=BabtDateUtil.obtainLastDay24OfnMonth(0);
		//int ccode=Integer.parseInt(cityCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return	baseMapper.queryGoeMonthCity(cond);
	}

	@Override
	public BabtStGoeMonthCity queryNMonthAgoByCity(String provinceCode, String cityCode, int nMonthAgo) {
		Date startTime=BabtDateUtil.obtainFirstDay0OfnMonth(nMonthAgo);
		Date endTime=BabtDateUtil.obtainLastDay24OfnMonth(nMonthAgo);
		//int ccode=Integer.parseInt(cityCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return	baseMapper.queryGoeMonthCity(cond);
	}

	@Override
	public BabtStGoeMonthDistrict query1MonthAgoByDistrict(String provinceCode, String cityCode, String districtCode) {
		//int nth=BabtDateUtil.obtainNthMonth();
		Date startTime=BabtDateUtil.obtainFirstDay0OfnMonth(0);
		Date endTime=BabtDateUtil.obtainLastDay24OfnMonth(0);
		//int dcode=Integer.parseInt(districtCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setDistrictCode(districtCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return	baseMapper.queryGoeMonthDistrict(cond);
	}

	@Override
	public BabtStGoeMonthDistrict queryNMonthAgoByDistrict(String provinceCode, String cityCode, String districtCode, int nMonthAgo) {
		//int nth=BabtDateUtil.obtainNthMonth();
		Date startTime=BabtDateUtil.obtainFirstDay0OfnMonth(nMonthAgo);
		Date endTime=BabtDateUtil.obtainLastDay24OfnMonth(nMonthAgo);
		//int dcode=Integer.parseInt(districtCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setDistrictCode(districtCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return	baseMapper.queryGoeMonthDistrict(cond);
	}

	@Override
	public BabtStGoeWeekProvince query1WeekAgoByProvince(String provinceCode) {
		
		Date startTime=BabtDateUtil.oneWeekAgoMonday0();
		Date endTime=BabtDateUtil.oneWeekAgoSunDay24();
		//int pcode=Integer.parseInt(provinceCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeWeekProvince(cond);
	}

	@Override
	public BabtStGoeWeekProvince queryNWeekAgoByProvince(String provinceCode, int nWeekAgo) {
		
		Date startTime=BabtDateUtil.nWeekAgoMonday0Date(nWeekAgo);
		Date endTime=BabtDateUtil.nWeekAgoMonday24Date(nWeekAgo);
		//int pcode=Integer.parseInt(provinceCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeWeekProvince(cond);
	}

	@Override
	public BabtStGoeWeekCity query1WeekAgoByCity(String provinceCode, String cityCode) {
		Date startTime=BabtDateUtil.oneWeekAgoMonday0();
		Date endTime=BabtDateUtil.oneWeekAgoSunDay24();
		//int code=Integer.parseInt(cityCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeWeekCity(cond);
	}

	@Override
	public BabtStGoeWeekCity queryNWeekAgoByCity(String provinceCode, String cityCode, int nWeekAgo) {
		Date startTime=BabtDateUtil.nWeekAgoMonday0Date(nWeekAgo);
		Date endTime=BabtDateUtil.nWeekAgoMonday24Date(nWeekAgo);
		//int code=Integer.parseInt(cityCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeWeekCity(cond);
	}

	@Override
	public BabtStGoeWeekDistrict query1WeekAgoByDistrict(String provinceCode, String cityCode, String districtCode) {
		Date startTime=BabtDateUtil.oneWeekAgoMonday0();
		Date endTime=BabtDateUtil.oneWeekAgoSunDay24();
		//int code=Integer.parseInt(districtCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setDistrictCode(districtCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeWeekDistrict(cond);
	}

	@Override
	public BabtStGoeWeekDistrict queryNWeekAgoByDistrict(String provinceCode, String cityCode, String districtCode, int nWeekAgo) {
		Date startTime=BabtDateUtil.nWeekAgoMonday0Date(nWeekAgo);
		Date endTime=BabtDateUtil.nWeekAgoMonday24Date(nWeekAgo);
		//int code=Integer.parseInt(districtCode);
		PcdMonthCond cond=new PcdMonthCond();
		cond.setProvinceCode(provinceCode);
		cond.setCityCode(cityCode);
		cond.setDistrictCode(districtCode);
		cond.setStartTime(startTime);
		cond.setEndTime(endTime);
		return baseMapper.queryGoeWeekDistrict(cond);
	}

}
