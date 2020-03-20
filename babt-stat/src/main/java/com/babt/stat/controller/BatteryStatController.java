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
	public double evlAvgSoc() {
		List<Integer> listnum=key();
		Iterator iteratorum=listnum.iterator();
		double sum=0;
		while(iteratorum.hasNext())
			sum+=evlTaskService.evlAvgSoc((int)iteratorum.next());
		return sum/listnum.size();
	}

	@RequestMapping(value = "/evlAvgSoc90")
	@ResponseBody
	public int evlAvgSoc90(){
		List<Integer> listnum=key();
		System.out.println(listnum);
		Iterator iteratornum=listnum.iterator();
		int i=0;
		while(iteratornum.hasNext())
			if(evlTaskService.evlAvgSoc90((int)iteratornum.next()).size()!=0) i++;
		return i;
	}

	@RequestMapping(value = "/evlAvgSoc80")
	@ResponseBody
	public int evlAvgSoc80(){
		List<Integer> listnum=key();
		Iterator iteratornum=listnum.iterator();
		int i=0;
		while(iteratornum.hasNext())
			if(evlTaskService.evlAvgSoc80((int)iteratornum.next()).size()!=0) i++;
		return i;
	}

	@RequestMapping(value = "/evlAvgSoc70")
	@ResponseBody
	public int evlAvgSoc70(){
		List<Integer> listnum=key();
		Iterator iteratornum=listnum.iterator();
		int i=0;
		while(iteratornum.hasNext())
			if(evlTaskService.evlAvgSoc70((int)iteratornum.next()).size()!=0) i++;
		return i;
	}

	@RequestMapping(value = "/evlAvgSoc60")
	@ResponseBody
	public int evlAvgSoc60(){
		List<Integer> listnum=key();
		Iterator iteratornum=listnum.iterator();
		int i=0;
		while(iteratornum.hasNext())
			if(evlTaskService.evlAvgSoc60((int)iteratornum.next()).size()!=0) i++;
		return i;
	}

	@RequestMapping(value = "/evlAvgSoc0")
	@ResponseBody
	public int evlAvgSoc0(){
		List<Integer> listnum=key();
		Iterator iteratornum=listnum.iterator();
		int i=0;
		while(iteratornum.hasNext())
			if(evlTaskService.evlAvgSoc0((int)iteratornum.next()).size()!=0) i++;
		return i;
	}

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

	@RequestMapping(value = "/batteryEvlBatteryCountLastYear")
	@ResponseBody
	public Map<Integer,Integer> batteryEvlBatteryCountLastYear(){
		Map<Integer,Integer> resultMap=new HashMap<Integer,Integer>();

		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		for(int i=1;i<=12;i++) {
			HashSet hashSetcar=new HashSet();
			for (int a : evlTaskService.batteryEvlBatteryCountLastYearCar(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"))
				hashSetcar.add(a);
			for (int b : evlTaskService.batteryEvlBatteryCountLastYearBattery(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"))
				hashSetcar.add(b);
			resultMap.put(i,hashSetcar.size());
		}
		return  resultMap;
	}
	@RequestMapping(value = "/evlAvgSOHCar90")
	@ResponseBody
	public Map<Integer,Double> evlAvgSOHCar90() {
		Map<Integer, List<BabtEvlTaskBattery>> map = new HashMap<Integer, List<BabtEvlTaskBattery>>();
		Map<Integer, Double> mapnum = new HashMap<Integer, Double>();


		HashSet hashSet = new HashSet();
		for (BabtMcBattery babtMcBattery : evlTaskService.totalBatteryEvlCountCar())
			hashSet.add(babtMcBattery.getId());
		System.out.println(hashSet);
		Iterator iterator = hashSet.iterator();
		while (iterator.hasNext()) {
			for (int i = 1; i <= hashSet.size(); i++)
				map.put(i, evlTaskService.evlAvgSocCar((int) iterator.next()));
		}
		for (int i = 1; i <= map.size(); i++){
			for(BabtEvlTaskBattery babtEvlTaskBatteryList:map.get(i)) {
//				System.out.println(babtEvlTaskBatteryList.getTaskID() + "---" + babtEvlTaskBatteryList.getCarModelId());
				for (BabtEvlReport babtEvlReport : evlTaskService.evlAvgSoc60(babtEvlTaskBatteryList.getTaskID())) {
					for (int d = 0; d < evlTaskService.evlAvgSoc60(babtEvlTaskBatteryList.getTaskID()).size(); d++)

					System.out.println(babtEvlTaskBatteryList.getTaskID()+"---"+babtEvlTaskBatteryList.getCarModelId()+"---"+babtEvlReport.getSoh());



				}
			}

		}
		return mapnum;
	}




	public List<Integer> key(){
		List<Integer> listnum = new ArrayList<Integer>();
		HashSet a = new HashSet();
		for (BabtMcBattery babtMcBattery : evlTaskService.totalBatteryEvlCountCar())
			a.add(babtMcBattery.getId());
		for (BabtMcBattery babtMcBattery1 : evlTaskService.totalBatteryEvlCountBattery())
			a.add(babtMcBattery1.getId());
//		System.out.println(a);
		Iterator iterator = a.iterator();
		while (iterator.hasNext()) {
			int cc = (int) iterator.next();
			List<BabtEvlTaskBattery> aa = evlTaskService.evlAvgSocCar(cc);
			List<BabtEvlTask> bb = evlTaskService.evlAvgSocBattery(cc);
			if (aa.size() == 0&&bb.size()!=0) {
				for (BabtEvlTask babtEvlTask : bb)
					listnum.add(babtEvlTask.getId());
			} else if (bb.size() == 0&&aa.size()!=0) {
				for (BabtEvlTaskBattery babtEvlTaskBattery : aa)
					listnum.add(babtEvlTaskBattery.getTaskID());
			} else {
				for (BabtEvlTaskBattery babtEvlTaskBattery : aa) {
					for (BabtEvlTask babtEvlTask : evlTaskService.evlAvgSocBattery(cc)) {
						if (babtEvlTask.getEndTime().compareTo(babtEvlTaskBattery.getEndTime()) == 1) {
							listnum.add(babtEvlTask.getId());
						} else {
							listnum.add(babtEvlTaskBattery.getTaskID());
						}
					}
				}
			}
		}
		return listnum;
	}



	
	

}
