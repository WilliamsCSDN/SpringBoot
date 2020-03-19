package com.babt.stat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babt.stat.entity.BatteryCapStat;
import com.babt.stat.entity.BatteryEvlStat;
import com.babt.stat.entity.BatterySurplusStat;
import com.babt.stat.entity.CarEvlStat;
import com.babt.stat.service.IBabtEvlTaskService;
import com.babt.stat.service.IBabtShcBatteryEvlRecordService;
import com.babt.stat.util.OrderUtil;

@Controller
@RequestMapping("/battery")
public class BatteryController {
	@Autowired
	private IBabtShcBatteryEvlRecordService shcBatteryEvlRecordService;

	@Autowired
	private IBabtEvlTaskService taskService;

//	// 4. 按地区统计二手评估电池总数
//	@RequestMapping(value = "/countByArea")
//	@ResponseBody
//	public Map<String, Integer> countByArea(Model model) {
//		List<BatteryEvlStat> shcBatteryCount = shcBatteryEvlRecordService.countBatteryByArea();
//		List<BatteryEvlStat> taskBatteryCount = taskService.countBatteryByArea();
//		Map<String, Integer> areaCountMap = new HashMap<String, Integer>();
//		if (CollectionUtils.isNotEmpty(shcBatteryCount)) {
//			for (BatteryEvlStat batteryEvlStat : shcBatteryCount) {
//				areaCountMap.put(batteryEvlStat.getArea(), batteryEvlStat.getCount());
//			}
//		}
//		if (CollectionUtils.isNotEmpty(taskBatteryCount)) {
//			for (BatteryEvlStat batteryEvlStat : taskBatteryCount) {
//				Integer existCount = areaCountMap.get(batteryEvlStat.getArea());
//				if (existCount == null || existCount == 0) {
//					areaCountMap.put(batteryEvlStat.getArea(), batteryEvlStat.getCount());
//				} else {
//					existCount += batteryEvlStat.getCount();
//					areaCountMap.put(batteryEvlStat.getArea(), existCount);
//				}
//			}
//		}
//
//		model.addAttribute("areaCountStat", areaCountMap);
//		return areaCountMap;
//
//	}
	
	// 4. 按地区统计二手评估电池总数
	@RequestMapping(value = "/countBatteryByProvinceInCountry")
	@ResponseBody
	public List<BatteryEvlStat> countBatteryByProvinceInCountry(Model model) {
		List<BatteryEvlStat> shcBatteryCounts = shcBatteryEvlRecordService.countBatteryByProvinceInCountry();
		model.addAttribute("shcBatteryCounts", shcBatteryCounts);
		return shcBatteryCounts;
	}

	// 4. 按地区统计二手评估电池总数
	@RequestMapping(value = "/countBatteryByCityInProvince")
	@ResponseBody
	public List<BatteryEvlStat> countBatteryByCityInProvince(Model model, String provinceCode) {
		List<BatteryEvlStat> shcBatteryCounts = shcBatteryEvlRecordService.countBatteryByCityInProvince(provinceCode);
		model.addAttribute("shcBatteryCounts", shcBatteryCounts);
		return shcBatteryCounts;
	}

	// 4. 按地区统计二手评估电池总数
	@RequestMapping(value = "/countBatteryByDistrictInProvinceCity")
	@ResponseBody
	public List<BatteryEvlStat> countBatteryByDistrictInProvinceCity(Model model, String provinceCode, String cityCode) {
		List<BatteryEvlStat> shcBatteryCounts = shcBatteryEvlRecordService.countBatteryByDistrictInProvinceCity(provinceCode, cityCode);
		model.addAttribute("shcBatteryCounts", shcBatteryCounts);
		return shcBatteryCounts;
	}

	// 6. 按月统计电池评估数量(过去12个月)
	@RequestMapping(value = "/countByMonth")
	@ResponseBody
	public Map<String, Integer> countByMonth(Model model) {
		List<BatteryEvlStat> countVsMonthShcList = shcBatteryEvlRecordService.countByMonth();
		List<BatteryEvlStat> countVsMonthTaskList = taskService.countBatteryByMonth();

		Map<String, Integer> areaCountMap = new HashMap<String, Integer>();
		if (CollectionUtils.isNotEmpty(countVsMonthShcList)) {
			for (BatteryEvlStat batteryEvlStat : countVsMonthShcList) {
				areaCountMap.put(batteryEvlStat.getMonth(), batteryEvlStat.getCount());
			}
		}
		if (CollectionUtils.isNotEmpty(countVsMonthTaskList)) {
			for (BatteryEvlStat batteryEvlStat : countVsMonthTaskList) {
				Integer existCount = areaCountMap.get(batteryEvlStat.getMonth());
				if (existCount == null || existCount == 0) {
					areaCountMap.put(batteryEvlStat.getMonth(), batteryEvlStat.getCount());
				} else {
					existCount += batteryEvlStat.getCount();
					areaCountMap.put(batteryEvlStat.getMonth(), existCount);
				}
			}
		}

		model.addAttribute("countMonthStat", areaCountMap);

		return areaCountMap;
	}

	// 7. 统计电池总容量，剩余容量
	@RequestMapping(value = "/capAndSup")
	@ResponseBody
	public BatteryCapStat countCapAndSup(Model model) {
		BatteryCapStat capStat = shcBatteryEvlRecordService.countCapAndSup();
		BatteryCapStat taskCapStat = taskService.countBatteryCapAndSup();
		double sumCap = 0;
		double sumSurplus = 0;
		if (capStat != null) {
			sumCap += capStat.getSumCapcity();
			sumSurplus += capStat.getSumSurplus();
		}
		if(taskCapStat!=null){
			sumCap += taskCapStat.getSumCapcity();
			sumSurplus += taskCapStat.getSumSurplus();
		}
		BatteryCapStat capStatResult = new BatteryCapStat(sumCap, sumSurplus);
		model.addAttribute("capStat", capStatResult);

		return capStatResult;
	}

	// 8. 按型号 统计5年左右(60-62个月)电池平均剩余top10
	@RequestMapping(value = "/fiveYearAgeSurplus")
	@ResponseBody
	public Map<String, BatteryCapStat> count5yearCsByModel(Model model) {
		List<BatteryCapStat> fiveYearAgeShcSurplus = shcBatteryEvlRecordService.count5yearCsByModel();
		List<BatteryCapStat> fiveYearAgeEvlSurplus = taskService.count5yearCsByModel();
		
		Map<String, BatteryCapStat> resultMap=OrderUtil.avgFiveYearCapByModel(fiveYearAgeShcSurplus, fiveYearAgeEvlSurplus);
		return resultMap;
	}

	//9. 做过评估的电池厂商数
	@RequestMapping(value = "/countManufacturer")
	@ResponseBody
	public int countManufacturer(Model model) {
		int countMaufactures = shcBatteryEvlRecordService.countManufacturer();
		return countMaufactures;
	}

	//10. 统计做过评估电池有多少种型号
	@RequestMapping(value = "/countModel")
	@ResponseBody
	public int countModel(Model model) {
		int modelCount = shcBatteryEvlRecordService.countModel();
		return modelCount;
	}
	
	//11. 评估过的电池数
	@RequestMapping(value = "/evalBatteryCount")
	@ResponseBody
	public int evalBatteryCount(Model model) {
		List<Integer> carEvlShcStats = shcBatteryEvlRecordService.evalBatteryCount();
		List<Integer> carEvlEvlStats = taskService.evalBatteryCount();
		int count = carEvlShcStats.size();
		if (CollectionUtils.isNotEmpty(carEvlEvlStats)) {
			for (int batteryId : carEvlEvlStats) {
				if(!carEvlShcStats.contains(batteryId))
				{
					count++;
				}
			}
		}
		return count;

	}
	
	//12. 做过电池评估的车辆 ，按型号group 统计每种型号的数目 TOP10
	@RequestMapping(value = "/countCarOfEvalBatteryByModel")
	@ResponseBody
	public Map<String,Integer> countCarOfEvalBatteryByModel(Model model){
		List<CarEvlStat> carList=shcBatteryEvlRecordService.countCarOfEvalBatteryByModel();
		List<CarEvlStat> taskCarList=taskService.countCarOfEvalBatteryByModel();
		Map<String,Integer>  resultMap=OrderUtil.top10ByModel(carList, taskCarList);
		return resultMap;
	}

	// 13. 根据车龄 按月 统计电池平均余量
	@RequestMapping(value = "/avgBatteryCapByAge")
	@ResponseBody
	public Map<Integer, CarEvlStat> avgBatteryCapByAge(Model model){
		List<CarEvlStat> carList=shcBatteryEvlRecordService.avgBatteryCapByAge();
		List<CarEvlStat> taskCarList=taskService.avgBatteryCapByAge();
		Map<Integer, CarEvlStat> resultMap=OrderUtil.avgCapByAge(carList, taskCarList);
		return resultMap;
	}

	// 18. 大数据评估比重（算法电池评估占总评估的比率）
	@RequestMapping(value = "/dataRatio")
	@ResponseBody
	public double dataRatio(Model model) {
		int molecule = taskService.countAll();// 分子
		int denominator = taskService.countByRecordIdNull() + shcBatteryEvlRecordService.evalBatteryTimes();//分母
		double result = (double)molecule / (double)denominator;
		return result;

	}

	// 19. 电池平均余能百分比
	@RequestMapping(value = "/avgSurplus")
	@ResponseBody
	public double avgSurplus(Model model) {
		BatterySurplusStat stat1 = shcBatteryEvlRecordService.surplusSum();
		BatterySurplusStat stat2 = taskService.surplusSum();
		double sohSum = stat1.getSohSum() + stat2.getSohSum();
		int count = stat1.getBatteryCount() + stat2.getBatteryCount();
		return sohSum / count;
	}

}
