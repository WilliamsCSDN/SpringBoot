package com.babt.stat.controller;

import java.util.*;

import com.babt.stat.entity.BabtEvlTask;
import com.babt.stat.entity.BabtEvlTaskBattery;
import com.babt.stat.entity.BabtMcBattery;
import com.babt.stat.service.IBabtEvlTaskService;
import com.sun.javafx.collections.MappingChange;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babt.stat.entity.BabtEvlReport;
import com.babt.stat.service.IBabtEvlReportService;

@Controller
@RequestMapping("/batterystat")
public class BatteryStatController {

	@Autowired
	private IBabtEvlTaskService evlTaskService;
	


	@RequestMapping(value = "/totalEvlCount")
	@ResponseBody
	public int totalEvlCount(){
		return evlTaskService.totalEvlCount();
	}

	@RequestMapping(value = "/totalBatteryEvlCount")
	@ResponseBody
	public int totalBatteryEvlCount(){
		HashSet a=new HashSet();
		for(BabtMcBattery babtMcBattery:evlTaskService.totalBatteryEvlCountCar())
			a.add(babtMcBattery.getId());
		for(BabtMcBattery babtMcBattery1:evlTaskService.totalBatteryEvlCountBattery())
			a.add(babtMcBattery1.getId());
		return a.size();
	}

	@RequestMapping(value = "/totalBatteryEvlCapacityCount")
	@ResponseBody
	public int totalBatteryEvlCapacityCount(){
		HashSet a=new HashSet();
		for(BabtMcBattery babtMcBattery:evlTaskService.totalBatteryEvlCountCar())
			a.add(babtMcBattery.getId());
		for(BabtMcBattery babtMcBattery1:evlTaskService.totalBatteryEvlCountBattery())
			a.add(babtMcBattery1.getId());
		int count=0;
		Iterator ccc=a.iterator();
		while(ccc.hasNext())
			count+=evlTaskService.totalBatteryEvlCapacityCount((int)ccc.next());
		return count;
		}

	@RequestMapping(value = "/evlAvgSoc")
	@ResponseBody
	public List<BabtEvlTask> evlAvgSoc(){
//		Map<Integer,Integer> cc=new HashMap<Integer,Integer>();
//		for(BabtEvlTaskBattery a:evlTaskService.evlAvgSoc()) {
//			int count=0;
//			for (BabtEvlTaskBattery b : evlTaskService.evlAvgSoc()) {
//				if (a.getBatteryID() == b.getBatteryID())
//					count++;
//			}
//			cc.put(a.getBatteryID(),count);
//		}
//		System.out.println(cc);

//		List<Integer> list1=new ArrayList<Integer>();
//		List<Integer> listnum=new ArrayList<Integer>();
//		List<Integer> listTotal=new ArrayList<Integer>();
//		for(Map.Entry<Integer,Integer> entry:cc.entrySet()) {
//			if (entry.getValue() > 1)
//				list1.add(entry.getKey());
//			else listnum.add(entry.getKey());
//		}
//		Iterator iterator=list1.iterator();
//		Iterator iteratornum=listnum.iterator();
//		Iterator iteratorTotal=listTotal.iterator();
//		while(iterator.hasNext())
//			listTotal.add(evlTaskService.evlAvgSoc1((int)iterator.next()));
//		while(iteratornum.hasNext())
//			listTotal.add(evlTaskService.evlAvgSoc1((int)iteratornum.next()));
//		System.out.println(listTotal);
//		double sum=0;
//
//		for(int i=0;i<listTotal.size();i++)
//			sum+=evlTaskService.evlAvgSoc2(listTotal.get(i));
//
//		System.out.println(sum);
//		return (sum/listTotal.size());



		return  evlTaskService.evlAvgSoc3();

	}

	@RequestMapping(value = "/evlAvgSoc90")
	@ResponseBody
	public int evlAvgSoc90(){return evlTaskService.evlAvgSoc90();}

	@RequestMapping(value = "/evlAvgSoc80")
	@ResponseBody
	public int evlAvgSoc80(){return evlTaskService.evlAvgSoc80();}

	@RequestMapping(value = "/evlAvgSoc70")
	@ResponseBody
	public int evlAvgSoc70(){return evlTaskService.evlAvgSoc70();}

	@RequestMapping(value = "/evlAvgSoc60")
	@ResponseBody
	public int evlAvgSoc60(){return evlTaskService.evlAvgSoc60();}

	@RequestMapping(value = "/evlAvgSoc0")
	@ResponseBody
	public int evlAvgSoc0(){return evlTaskService.evlAvgSoc0();}

	@RequestMapping(value = "/carTotalEvlCount")
	@ResponseBody
	public int carTotalEvlCount(){return evlTaskService.carTotalEvlCount();}

	@RequestMapping(value = "/batteryTotalEvlCount")
	@ResponseBody
	public int batteryTotalEvlCount(){return evlTaskService.batteryTotalEvlCount();}

	@RequestMapping(value = "/batteryEvlCarCount")
	@ResponseBody
	public int batteryEvlCarCount(){return evlTaskService.batteryEvlCarCount();}

	@RequestMapping(value = "/batteryEvlBatteryCount")
	@ResponseBody
	public int batteryEvlBatteryCount(){return evlTaskService.batteryEvlBatteryCount();}

	@RequestMapping(value = "/batteryEvlCountLastYear")
	@ResponseBody
	public Map<Integer,Integer> batteryEvlCountLastYear(){
		Map<Integer,Integer> countLastYear=new HashMap<Integer, Integer>();

		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		for(int i=1;i<=12;i++) {
			countLastYear.put(i, evlTaskService.batteryEvlCountLastYear(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"));
		}
		return countLastYear;
	}



	
	

}
