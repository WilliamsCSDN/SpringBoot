package com.babt.stat.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;

import com.babt.stat.entity.BatteryCapStat;
import com.babt.stat.entity.CarEvlStat;

public class OrderUtil {

	public static Map<String, Integer> top10ByModel(List<CarEvlStat> oneList, List<CarEvlStat> otherList) {
		Map<String, Integer> modelNameVsCount = new TreeMap<String, Integer>();
		if (CollectionUtils.isNotEmpty(oneList)) {
			for (CarEvlStat carEvlStat : oneList) {
				modelNameVsCount.put(carEvlStat.getModelName(), carEvlStat.getCount());
			}
		}
		if (CollectionUtils.isNotEmpty(otherList)) {
			for (CarEvlStat carEvlStat : otherList) {
				Integer count = modelNameVsCount.get(carEvlStat.getModelName());
				if (count == null || count == 0) {
					modelNameVsCount.put(carEvlStat.getModelName(), carEvlStat.getCount());
				} else {
					count += carEvlStat.getCount();
					modelNameVsCount.put(carEvlStat.getModelName(), count);
				}
			}
		}
		Set<Entry<String, Integer>> entrySet = modelNameVsCount.entrySet();
		
		List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return  o2.getValue().compareTo(o1.getValue());
            }
        }); //倒排
		int index = 0;
		if (entrySet.size() > 10) {
			// 取top10
			for (Iterator<Entry<String, Integer>> iterator = entrySet.iterator(); iterator.hasNext();) {
				if (index++ >= 10 ) {
					iterator.remove();
				}
			}
		}

		return modelNameVsCount;
	}
	
	
	public static Map<Integer, CarEvlStat> avgCapByAge(List<CarEvlStat> oneList, List<CarEvlStat> otherList) {
		Map<Integer, CarEvlStat> ageVsCarEvlStat = new TreeMap<Integer, CarEvlStat>();
		if (CollectionUtils.isNotEmpty(oneList)) {
			for (CarEvlStat carEvlStat : oneList) {
				ageVsCarEvlStat.put(carEvlStat.getAge(), carEvlStat);
			}
		}
		if (CollectionUtils.isNotEmpty(otherList)) {
			for (CarEvlStat carEvlStat : otherList) {
				CarEvlStat carEvlStatTmp = ageVsCarEvlStat.get(carEvlStat.getAge());
				if (carEvlStatTmp == null) {
					ageVsCarEvlStat.put(carEvlStat.getAge(), carEvlStat);
				} else {
					int count = carEvlStatTmp.getCount()+carEvlStat.getCount();
					double avgSurplusCap = ((carEvlStatTmp.getAvgSurplusCap()*carEvlStatTmp.getCount())+
							(carEvlStat.getAvgSurplusCap()*carEvlStat.getCount()))/count;
					CarEvlStat newEvlStat = new CarEvlStat();
					newEvlStat.setAge(carEvlStat.getAge());
					newEvlStat.setCount(count);
					newEvlStat.setAvgSurplusCap(avgSurplusCap);
					ageVsCarEvlStat.put(carEvlStat.getAge(), newEvlStat);
				}
			}
		}
		return ageVsCarEvlStat;
	}
	
	
	public static Map<String, BatteryCapStat> avgFiveYearCapByModel(List<BatteryCapStat> oneList, List<BatteryCapStat> otherList) {
		Map<String, BatteryCapStat> modelVscapEvlStat = new TreeMap<String, BatteryCapStat>();
		if (CollectionUtils.isNotEmpty(oneList)) {
			for (BatteryCapStat batteryCapStat : oneList) {
				modelVscapEvlStat.put(batteryCapStat.getModelName(), batteryCapStat);
			}
		}
		if (CollectionUtils.isNotEmpty(otherList)) {
			for (BatteryCapStat batteryCapStat : otherList) {
				BatteryCapStat batteryCapStatTmp = modelVscapEvlStat.get(batteryCapStat.getModelName());
				if (batteryCapStatTmp == null) {
					modelVscapEvlStat.put(batteryCapStat.getModelName(), batteryCapStat);
				} else {
					int count = batteryCapStatTmp.getCount()+batteryCapStat.getCount();
					double avgSurplusCap = ((batteryCapStatTmp.getAvgSurplus()*batteryCapStatTmp.getCount())+
							(batteryCapStat.getAvgSurplus()*batteryCapStat.getCount()))/count;
					BatteryCapStat newEvlStat = new BatteryCapStat();
					newEvlStat.setModelName(batteryCapStat.getModelName());
					newEvlStat.setCount(count);
					newEvlStat.setAvgSurplus(avgSurplusCap);
					modelVscapEvlStat.put(batteryCapStat.getModelName(), newEvlStat);
				}
			}
		}
		return modelVscapEvlStat;
	}
	
}
