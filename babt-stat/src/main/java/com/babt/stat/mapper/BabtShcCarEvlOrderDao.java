package com.babt.stat.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.babt.stat.entity.BabtAreaCode;
import com.babt.stat.entity.BabtShcCarEvlOrder;
import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.babt.stat.entity.BabtStGoeWeekCity;
import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.babt.stat.entity.cond.PcdMonthCond;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 整车评估委托订单 Mapper 接口
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface BabtShcCarEvlOrderDao extends BaseMapper<BabtShcCarEvlOrder> {

	@Select("select distinct ProvinceCode as province  from  babt_shc_car_evl_order")
	public List<BabtAreaCode> queryAllProvince();
	
	@Select("select distinct ProvinceCode as province, CityCode as city from  babt_shc_car_evl_order")
	public List<BabtAreaCode> queryAllCity();
	
	@Select("select distinct ProvinceCode as province, CityCode as city, DistrictCode as district from  babt_shc_car_evl_order")
	public List<BabtAreaCode> queryAllDistrict();
	
	public BabtStGoeMonthProvince  queryGoeMonthProvince(PcdMonthCond cond);
	
	public BabtStGoeMonthCity  queryGoeMonthCity(PcdMonthCond cond);
	
	public BabtStGoeMonthDistrict  queryGoeMonthDistrict(PcdMonthCond cond);
	
	
	
	public BabtStGoeWeekProvince  queryGoeWeekProvince(PcdMonthCond cond);
	
	public BabtStGoeWeekCity  queryGoeWeekCity(PcdMonthCond cond);
	
	public BabtStGoeWeekDistrict  queryGoeWeekDistrict(PcdMonthCond cond);
	
}
