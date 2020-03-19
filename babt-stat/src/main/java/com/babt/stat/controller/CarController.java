package com.babt.stat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babt.stat.entity.BabtAreaCode;
import com.babt.stat.entity.BabtStAvgEvalTimeConsumer;
import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.babt.stat.entity.BabtStGoeWeekCity;
import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.babt.stat.entity.CarEvlStat;
import com.babt.stat.entity.cond.Car4StatCond;
import com.babt.stat.entity.vo.Car4Stat;
import com.babt.stat.service.IBabtAreaCodeService;
import com.babt.stat.service.IBabtShcCarEvlRecordService;
import com.babt.stat.service.IBabtStAvgEvalTimeConsumerService;
import com.babt.stat.service.IBabtStGoeMonthCityService;
import com.babt.stat.service.IBabtStGoeMonthDistrictService;
import com.babt.stat.service.IBabtStGoeMonthProvinceService;
import com.babt.stat.service.IBabtStGoeWeekCityService;
import com.babt.stat.service.IBabtStGoeWeekDistrictService;
import com.babt.stat.service.IBabtStGoeWeekProvinceService;
import com.babt.stat.util.BabtDateUtil;

@Controller
@RequestMapping("/car")
public class CarController {

	private Logger logger = Logger.getLogger(CarController.class);

	@Autowired
	private IBabtShcCarEvlRecordService shcCarEvlRecordService;

	@Autowired
	private IBabtStAvgEvalTimeConsumerService avgEvalTimeConsumerService;

	@Autowired
	private IBabtStGoeMonthProvinceService goeMonthProvinceService;

	@Autowired
	private IBabtStGoeMonthCityService goeMonthCityService;

	@Autowired
	private IBabtStGoeMonthDistrictService goeMonthDistrictService;

	@Autowired
	private IBabtStGoeWeekProvinceService goeWeekProvinceService;

	@Autowired
	private IBabtStGoeWeekCityService goeWeekCityService;

	@Autowired
	private IBabtStGoeWeekDistrictService goeWeekDistrictService;
	
	@Autowired
	private IBabtAreaCodeService areaCodeService;

	// 1.根据车型统计车数量TOP10(12个月内)
	@RequestMapping(value = "/countByCarModel")
	@ResponseBody
	public List<CarEvlStat> countByCarModel(Model model) {
		List<CarEvlStat> list = shcCarEvlRecordService.statCountByCarModel();
		return list;
	}
	// 2. 车辆评估数量 月曲线
	@RequestMapping(value = "/countByMonth")
	@ResponseBody
	public List<CarEvlStat> countByMonth(Model model) {
		List<CarEvlStat> list = shcCarEvlRecordService.statCountByMonth();
		return list;
	}

	// 3.按周统计评估耗时长
	@RequestMapping(value = "/evlTimeConsume")
	@ResponseBody
	public List<CarEvlStat> evlTimeConsume(Model model) {
		List<CarEvlStat> list = shcCarEvlRecordService.evlTimeConsumeByWeek();
		return list;
	}

	// //5. 按地区统计车辆评估数量
	// @RequestMapping(value = "/countByArea")
	// @ResponseBody
	// public List<CarEvlStat> countByArea(Model model) {
	// List<CarEvlStat> list=shcCarEvlRecordService.statCountByArea();
	// return list;
	// }

	// 5. 按地区统计车辆评估数量
	@RequestMapping(value = "/countByProvinceInCountry")
	@ResponseBody
	public List<CarEvlStat> countByProvinceInCountry(Model model) {
		List<CarEvlStat> list = shcCarEvlRecordService.statCountByProvinceInCountry();
		return list;
	}

	// 5. 按地区统计车辆评估数量
	@RequestMapping(value = "/countByCityInProvince")
	@ResponseBody
	public List<CarEvlStat> countByCityInProvince(Model model, String provinceCode) {
		List<CarEvlStat> list = shcCarEvlRecordService.statCountByCityInProvince(provinceCode);
		return list;
	}

	// 5. 按地区统计车辆评估数量
	@RequestMapping(value = "/countByDistrictInProvinceCity")
	@ResponseBody
	public List<CarEvlStat> countByDistrictInProvinceCity(Model model, String provinceCode, String cityCode) {
		List<CarEvlStat> list = shcCarEvlRecordService.statCountByDistrictInProvinceCity(provinceCode, provinceCode);
		return list;
	}

	// 14. 经过评估的覆盖城市数量
	@RequestMapping(value = "/countCity")
	@ResponseBody
	public int countCity(Model model) {
		int countCity = shcCarEvlRecordService.countCity();
		return countCity;
	}

	// 15. 经过评估的二手车厂商数量
	@RequestMapping(value = "/countCarManufacture")
	@ResponseBody
	public int countCarManufacture(Model model) {

		int count = shcCarEvlRecordService.countCarManufacture();
		return count;
	}

	// 16. 经过评估的二手车车型数量
	@RequestMapping(value = "/countCarModel")
	@ResponseBody
	public int countCarModel(Model model) {
		return shcCarEvlRecordService.countCarModel();
	}

	// 17. 经过评估的二手车数量
	@RequestMapping(value = "/countEvalCar")
	@ResponseBody
	public int countEvalCar(Model model) {
		return shcCarEvlRecordService.countEvalCar();
	}

	@ResponseBody
	@RequestMapping(value = "/evalTimeConsumeByWeek")
	public List<BabtStAvgEvalTimeConsumer> evalTimeConsumeByWeek() {
		List<BabtStAvgEvalTimeConsumer> list = new ArrayList<BabtStAvgEvalTimeConsumer>();
		for (int i = 0; i < 52; i++) {
			BabtStAvgEvalTimeConsumer oneRecord = avgEvalTimeConsumerService.queryNweekAgo(i);
			if (oneRecord != null) {
				list.add(oneRecord);
			}
		}
		return list;
	}

	// 按地区统计车辆，平均里程
	@ResponseBody
	@RequestMapping(value = "/queryAvgMileByArea")
	public List<CarEvlStat> queryAvgMileByArea() {
		return shcCarEvlRecordService.avgMileCountByArea();
	}

	// 遗失需求 统计4项数据 (第一天的统计需求)
	@ResponseBody
	@RequestMapping(value = "/data4map")
	public Car4Stat data4map(Car4StatCond carCond) {
		Integer carCount = shcCarEvlRecordService.queryEvalCarsByCond(carCond);
		Double avgRate = shcCarEvlRecordService.queryAvgRateByCond(carCond);
		Double avgAge = shcCarEvlRecordService.queryAvgAgeByCond(carCond);
		Double avgMile = shcCarEvlRecordService.queryAvgMileByCond(carCond);
		Car4Stat car4Stat = new Car4Stat(carCount, avgRate, avgAge, avgMile);
		car4Stat.setCond(carCond);
		return car4Stat;

	}

	// 遗失需求(第一天的统计需求之下图需求)
	@ResponseBody
	@RequestMapping(value = "/goeStat")
	public HashMap<String, Object> goeStat(String province, String city, Integer codeType, Integer n, Integer intervalType) {
		HashMap<String, Object> datemap = new HashMap<String, Object>();
		//province:省全称, city:市全称 , codeType:0=国内所有省统计  1=省内所有市统计 2=市内所有区统计 , intervalType:0=按月统计  1=按周统计
		if(codeType!=null && intervalType!=null)
		{
			if(codeType==0 && intervalType==0){
				List<BabtAreaCode> areas = areaCodeService.showProvinceInCountry();
				for (int i = 0; i < n; i++) {
					HashMap<String, Object> areamap = new HashMap<String, Object>();
					for(BabtAreaCode area : areas)
					{
						List<BabtStGoeMonthProvince> list  = goeMonthProvinceService.queryByMonthProvince(area.getProvince(), i);
						areamap.put(area.getProvince(), list);
						
					}
					String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(i);
					datemap.put(firstDateOfnMonthAgo, areamap);
				}
			}
			else if(codeType==0 && intervalType==1){
				List<BabtAreaCode> areas = areaCodeService.showProvinceInCountry();
				for (int i = 0; i < n; i++) {
					HashMap<String, Object> areamap = new HashMap<String, Object>();
					for(BabtAreaCode area : areas)
					{
						List<BabtStGoeWeekProvince> list = goeWeekProvinceService.queryByWeekProvince(area.getProvince(), i);
						areamap.put(area.getProvince(), list);
					}
					String mondayOfnWeekAgo=BabtDateUtil.nWeekAgoMonday0(i);
					datemap.put(mondayOfnWeekAgo, areamap);
				}
			}
			else if(codeType==1 && intervalType==0 && province!=null && !province.isEmpty()){
				List<BabtAreaCode> areas = areaCodeService.showCityInProvince(province);
				for (int i = 0; i < n; i++) {
					HashMap<String, Object> areamap = new HashMap<String, Object>();
					for(BabtAreaCode area : areas)
					{
						List<BabtStGoeMonthCity> list = goeMonthCityService.queryByMonthCity(area.getProvince(), area.getCity(), i);
						areamap.put(area.getCity(), list);
					}
					String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(i);
					datemap.put(firstDateOfnMonthAgo, areamap);
				}
			}
			else if(codeType==1 && intervalType==1 && province!=null && !province.isEmpty()){
				List<BabtAreaCode> areas = areaCodeService.showCityInProvince(province);
				for (int i = 0; i < n; i++) {
					HashMap<String, Object> areamap = new HashMap<String, Object>();
					for(BabtAreaCode area : areas)
					{
						List<BabtStGoeWeekCity> list = goeWeekCityService.queryByWeekCity(area.getProvince(), area.getCity(), i);
						areamap.put(area.getCity(), list);
					}
					String mondayOfnWeekAgo=BabtDateUtil.nWeekAgoMonday0(i);
					datemap.put(mondayOfnWeekAgo, areamap);
				}
			}
			else if(codeType==2 && intervalType==0 && province!=null && !province.isEmpty() && city!=null && !city.isEmpty()){
				List<BabtAreaCode> areas = areaCodeService.showDistrictInProvinceCity(province, city);
				for (int i = 0; i < n; i++) {
					HashMap<String, Object> areamap = new HashMap<String, Object>();
					for(BabtAreaCode area : areas)
					{
						List<BabtStGoeMonthDistrict> list = goeMonthDistrictService.queryByMonthDistrict(area.getProvince(), area.getCity(), area.getDistrict(), i);
						areamap.put(area.getDistrict(), list);
					}
					String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(i);
					datemap.put(firstDateOfnMonthAgo, areamap);
				}
			}
			else if(codeType==2 && intervalType==1 && province!=null && !province.isEmpty() && city!=null && !city.isEmpty()){
				List<BabtAreaCode> areas = areaCodeService.showDistrictInProvinceCity(province, city);
				for (int i = 0; i < n; i++) {
					HashMap<String, Object> areamap = new HashMap<String, Object>();
					for(BabtAreaCode area : areas)
					{
						List<BabtStGoeWeekDistrict> list = goeWeekDistrictService.queryByWeekDistrict(area.getProvince(), area.getCity(), area.getDistrict(), i);
						areamap.put(area.getDistrict(), list);
					}
					String mondayOfnWeekAgo=BabtDateUtil.nWeekAgoMonday0(i);
					datemap.put(mondayOfnWeekAgo, areamap);
				}
			}
		}
		
		return datemap;

	}

}
