package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtAreaCode;
import com.babt.stat.entity.BabtShcCarEvlOrder;
import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.babt.stat.entity.BabtStGoeWeekCity;
import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 整车评估委托订单 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface IBabtShcCarEvlOrderService extends IService<BabtShcCarEvlOrder> {
	
	public List<BabtAreaCode> queryAllProvince();
	
	public List<BabtAreaCode> queryAllCity();
	
	public List<BabtAreaCode> queryAllDistrict();
	
	public BabtStGoeMonthProvince query1MonthAgoByProvince(String provinceCode);
	public BabtStGoeMonthProvince queryNMonthAgoByProvince(String provinceCode, int nMonthAgo);
	
	public BabtStGoeMonthCity query1MonthAgoByCity(String provinceCode, String cityCode);
	public BabtStGoeMonthCity queryNMonthAgoByCity(String provinceCode, String cityCode, int nMonthAgo);
	
	public BabtStGoeMonthDistrict query1MonthAgoByDistrict(String provinceCode, String cityCode, String districtCode);
	public BabtStGoeMonthDistrict queryNMonthAgoByDistrict(String provinceCode, String cityCode, String districtCode, int nMonthAgo);
	
	
	public BabtStGoeWeekProvince query1WeekAgoByProvince(String provinceCode);
	public BabtStGoeWeekProvince queryNWeekAgoByProvince(String provinceCode, int nWeekAgo);
	
	public BabtStGoeWeekCity query1WeekAgoByCity(String provinceCode, String cityCode);
	public BabtStGoeWeekCity queryNWeekAgoByCity(String provinceCode, String cityCode, int nWeekAgo);
	
	public BabtStGoeWeekDistrict query1WeekAgoByDistrict(String provinceCode, String cityCode, String districtCode);
	public BabtStGoeWeekDistrict queryNWeekAgoByDistrict(String provinceCode, String cityCode, String districtCode, int nWeekAgo);

}
