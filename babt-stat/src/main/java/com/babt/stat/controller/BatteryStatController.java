package com.babt.stat.controller;

import java.rmi.MarshalledObject;
import java.util.*;

import com.babt.stat.entity.*;
import com.babt.stat.service.IBabtEvlTaskService;
import com.sun.javafx.collections.MappingChange;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.babt.stat.service.IBabtEvlReportService;

@Controller
@CrossOrigin
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
	public Map<Object,Object> evlAvgSOHCar90() {
		return  key1(0.9);
	}
	@RequestMapping(value = "/evlAvgSOHCar80")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHCar80() {
		return  key1(0.8);
	}
	@RequestMapping(value = "/evlAvgSOHCar70")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHCar70() {
		return  key1(0.7);
	}
	@RequestMapping(value = "/evlAvgSOHCar60")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHCar60() {
		return  key1(0.6);
	}
	@RequestMapping(value = "/evlAvgSOHCar0")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHCar0() {
		return  key1(0);
	}


	@RequestMapping("/carBatteryEvlCount")
	@ResponseBody
	public int carBatteryEvlCount(){
		return evlTaskService.carBatteryEvlCount();
	}
	@RequestMapping("/carBatteryEvlCarCount")
	@ResponseBody
	public int carBatteryEvlCarCount(){
		return evlTaskService.carBatteryEvlCarCount();
	}
	@RequestMapping("/carBatteryEvlCarModelCount")
	@ResponseBody
	public int carBatteryEvlCarModelCount(){
		return evlTaskService.carBatteryEvlCarModelCount();
	}
	@RequestMapping("/dBatteryEvlCount")
	@ResponseBody
	public int dBatteryEvlCount(){
		return evlTaskService.dBatteryEvlCount();
	}
	@RequestMapping("/dBatteryEvlBatteryCount")
	@ResponseBody
	public int dBatteryEvlBatteryCount(){
		return evlTaskService.dBatteryEvlBatteryCount();
	}
	@RequestMapping("/dBatteryEvlBatteryModelCount")
	@ResponseBody
	public int dBatteryEvlBatteryModelCount(){
		return evlTaskService.dBatteryEvlBatteryModelCount();
	}
	@RequestMapping("/carBatteryEvlCountLastYear")
	@ResponseBody
	public Map<Integer,Integer> carBatteryEvlCountLastYear(){
		Map<Integer,Integer> countLastYear=new HashMap<Integer, Integer>();
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		for(int i=1;i<=12;i++) {
			countLastYear.put(i, evlTaskService.carBatteryEvlCountLastYear(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"));
		}
		return countLastYear;
	}
	@RequestMapping("/carBatteryEvlCarCountLastYear")
	@ResponseBody
	public Map<Integer,Integer> carBatteryEvlCarCountLastYear(){
		Map<Integer,Integer> countLastYear=new HashMap<Integer, Integer>();
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		for(int i=1;i<=12;i++) {
			countLastYear.put(i, evlTaskService.carBatteryEvlCarCountLastYear(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"));
		}
		return countLastYear;
	}
	@RequestMapping("/dBatteryEvlCountLastYear")
	@ResponseBody
	public Map<Integer,Integer> dBatteryEvlCountLastYear(){
		Map<Integer,Integer> countLastYear=new HashMap<Integer, Integer>();
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		for(int i=1;i<=12;i++) {
			countLastYear.put(i, evlTaskService.dBatteryEvlCountLastYear(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"));
		}
		return countLastYear;
	}
	@RequestMapping("/dBatteryEvlBatteryCountLastYear")
	@ResponseBody
	public Map<Integer,Integer> dBatteryEvlBatteryCountLastYear(){
		Map<Integer,Integer> countLastYear=new HashMap<Integer, Integer>();
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		for(int i=1;i<=12;i++) {
			countLastYear.put(i, evlTaskService.dBatteryEvlBatteryCountLastYear(((c.get(Calendar.YEAR) - 1) + "-" + i + "-1"), (c.get(Calendar.YEAR) - 1) + "-" + (i + 1) + "-1"));
		}
		return countLastYear;
	}

	@RequestMapping("/carBatteryEvlCarModelCountTop")
	@ResponseBody
	public Map<Integer,Integer> carBatteryEvlCarModelCountTop(){
		List<Integer> a=evlTaskService.carBatteryEvlCarModelCountTop();
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		Map<Integer,Integer> mapresult=new HashMap<Integer, Integer>();
		for(int i=0;i<a.size();i++){
			if(!map.containsKey(a.get(i)))
				map.put(a.get(i),1);
			else map.put(a.get(i),map.get(a.get(i))+1);
		}

		List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		System.out.println(list);
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<Integer,Integer> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;

	}

	@RequestMapping("/carBatteryEvlManufacturerCount")
	@ResponseBody
	public int carBatteryEvlManufacturerCount(){
		return evlTaskService.carBatteryEvlManufacturerCount();
	}
	@RequestMapping("/dBatteryEvlManufacturerCount")
	@ResponseBody
	public int dBatteryEvlManufacturerCount(){
		return evlTaskService.dBatteryEvlManufacturerCount();
	}
	@RequestMapping("/evlAvgSOHBattery90")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHBattery90(){
		return key2(0.9);
	}
	@RequestMapping("/evlAvgSOHBattery80")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHBattery80(){
		return key2(0.8);
	}
	@RequestMapping("/evlAvgSOHBattery70")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHBattery70(){
		return key2(0.7);
	}
	@RequestMapping("/evlAvgSOHBattery60")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHBattery60(){
		return key2(0.6);
	}
	@RequestMapping("/evlAvgSOHBattery0")
	@ResponseBody
	public Map<Object,Object> evlAvgSOHBattery0(){
		return key2(0);
	}
	@RequestMapping("/carBatteryEvlSohCarModelCountTop")
	@ResponseBody
	public Map<Integer,Double> carBatteryEvlSohCarModelCountTop(){
		Map<Integer,Double> map=new HashMap<>();
		HashSet hashSet=new HashSet();
		Map<Integer,Double> mapresult=new HashMap<>();
		for(BabtEvlCar babtEvlCar:evlTaskService.evlAvgSOHCar90()){
			hashSet.add(babtEvlCar.getCarModelId());
		}
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			int a=(int)iterator.next();
			int count=0;
			double sohcount=0;

			for (BabtEvlCar babtEvlCar2 : evlTaskService.evlAvgSOHCar90()) {
				if (babtEvlCar2.getCarModelId()==a) {
					sohcount += babtEvlCar2.getSOH();
					count++;
				}
			}
			map.put(a,sohcount/count);

		}

		List<Map.Entry<Integer,Double>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			@Override
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
			}
		});
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<Integer,Double> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;
	}

	@RequestMapping("/carBatteryEvlManufacturerCountTop")
	@ResponseBody
	public Map<String,Integer> carBatteryEvlManufacturerCountTop(){
		HashSet hashSet=new HashSet();
		Map<String,Integer> map=new HashMap<>();
		Map<String,Integer> mapresult=new HashMap<>();
		for(String a:evlTaskService.carBatteryEvlManufacturerCountTop())
		hashSet.add(a);
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			String a=(String)iterator.next();
			map.put(a,evlTaskService.carBatteryEvlManufacturerCountTOPCount(a));

		}
		List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<String,Integer> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());

		System.out.println(mapresult);
		return mapresult;

	}
	@RequestMapping("/carBatteryEvlSohManufacturerCountTop")
	@ResponseBody
	public Map<String,Double> carBatteryEvlSohManufacturerCountTop(){
		HashSet hashSet=new HashSet();
		Map<String,Double> map=new HashMap<>();
		Map<String,Double> mapresult=new HashMap<>();
		for(BabtEvlCarManufacturer babtEvlCarManufacturer:evlTaskService.carBatteryEvlSohManufacturerCountTop())
			hashSet.add(babtEvlCarManufacturer.getNameCN());
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			String a=(String)iterator.next();
			int count=0;
			double sohcount=0;

			for (BabtEvlCarManufacturer babtEvlCarManufacturer2 : evlTaskService.carBatteryEvlSohManufacturerCountTop()) {
				if (babtEvlCarManufacturer2.getNameCN()==a||a.equals(babtEvlCarManufacturer2.getNameCN())) {
					sohcount += babtEvlCarManufacturer2.getSOH();
					count++;
				}
			}
			map.put(a,sohcount/count);

		}

		List<Map.Entry<String,Double>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
			}
		});
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<String,Double> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;

	}
	@RequestMapping("/dBatteryEvlCarModelCountTop")
	@ResponseBody
	public Map<Integer,Integer> dBatteryEvlCarModelCountTop(){
		List<Integer> a=evlTaskService.dBatteryEvlCarModelCountTop();
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		Map<Integer,Integer> mapresult=new HashMap<Integer, Integer>();
		for(int i=0;i<a.size();i++){
			if(!map.containsKey(a.get(i)))
				map.put(a.get(i),1);
			else map.put(a.get(i),map.get(a.get(i))+1);
		}

		List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		System.out.println(list);
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<Integer,Integer> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;
	}
	@RequestMapping("/dBatteryEvlSohCarModelCountTop")
	@ResponseBody
	public Map<Integer,Double> dBatteryEvlSohCarModelCountTop(){
		Map<Integer,Double> map=new HashMap<>();
		Map<Integer,Double> mapresult=new HashMap<>();
		HashSet hashSet=new HashSet();
		for(BabtEvlBattery babtEvlBattery:evlTaskService.evlAvgSOHBattery90()){
			hashSet.add(babtEvlBattery.getProductModeID());
		}
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			int a=(int)iterator.next();
			int count=0;
			double sohcount=0;

			for (BabtEvlBattery babtEvlBattery2 : evlTaskService.evlAvgSOHBattery90()) {
				if (babtEvlBattery2.getProductModeID()==a) {
					sohcount += babtEvlBattery2.getSOH();
					count++;
				}
			}
			map.put(a,sohcount/count);

		}

		List<Map.Entry<Integer,Double>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			@Override
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
			}
		});
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<Integer,Double> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;
	}

	@RequestMapping("/dBatteryEvlManufacturerCountTop")
	@ResponseBody
	public Map<String,Integer> dBatteryEvlManufacturerCountTop(){
		HashSet hashSet=new HashSet();
		Map<String,Integer> map=new HashMap<>();
		Map<String,Integer> mapresult=new HashMap<>();
		for(String a:evlTaskService.dBatteryEvlManufacturerCountTop())
			hashSet.add(a);
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			String a=(String)iterator.next();
			map.put(a,evlTaskService.dBatteryEvlManufacturerCountTopCount(a));

		}
		List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<String,Integer> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;
	}
	@RequestMapping("/dBatteryEvlSohManufacturerCountTop")
	@ResponseBody
	public Map<String,Double> dBatteryEvlSohManufacturerCountTop(){
		HashSet hashSet=new HashSet();
		Map<String,Double> map=new HashMap<>();
		Map<String,Double> mapresult=new HashMap<>();
		for(BabtEvlBatteryManufacturer babtEvlBatteryManufacturer:evlTaskService.dBatteryEvlSohManufacturerCountTop())
			hashSet.add(babtEvlBatteryManufacturer.getBatteryManufacturer());
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			String a=(String)iterator.next();
			int count=0;
			double sohcount=0;

			for (BabtEvlBatteryManufacturer babtEvlBatteryManufacturer2: evlTaskService.dBatteryEvlSohManufacturerCountTop()) {
				if (babtEvlBatteryManufacturer2.getBatteryManufacturer()==a||a.equals(babtEvlBatteryManufacturer2.getBatteryManufacturer())) {
					sohcount += babtEvlBatteryManufacturer2.getSOH();
					count++;
				}
			}
			map.put(a,sohcount/count);

		}

		List<Map.Entry<String,Double>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			@Override
			public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
			}
		});
		if(list.size()>10) list=list.subList(0,10);
		for(Map.Entry<String,Double> map1:list)
			mapresult.put(map1.getKey(),map1.getValue());
		return mapresult;

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
	public Map<Object,Object> key1(double aa){
		Map<Integer,Double> map=new HashMap<>();
		Map<Object,Object> mapresult=new HashMap<>();
		HashSet hashSet=new HashSet();
		for(BabtEvlCar babtEvlCar:evlTaskService.evlAvgSOHCar90()){
			hashSet.add(babtEvlCar.getCarModelId());
		}
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			int a=(int)iterator.next();
			int count=0;
			double sohcount=0;

			for (BabtEvlCar babtEvlCar2 : evlTaskService.evlAvgSOHCar90()) {
				if (babtEvlCar2.getCarModelId()==a) {
					sohcount += babtEvlCar2.getSOH();
					count++;
				}
			}
			map.put(a,sohcount/count);

		}

		List<Map.Entry<Integer,Double>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			@Override
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
			}
		});
		System.out.println(list);
		List<Integer> list1=new ArrayList<Integer>();
		List<Double> list2=new ArrayList<Double>();
		for (Map.Entry s : list)
		{
			if(aa==0){
				if((Double)s.getValue()<(aa+0.6)&&(Double)s.getValue()>=aa){
//				mapresult.put((int)s.getKey(),(Double)s.getValue());
					list1.add((int)s.getKey());
					list2.add((double)s.getValue());
				}
			}else {
				if ((Double) s.getValue() < (aa + 0.1) && (Double) s.getValue() >= aa) {
//				mapresult.put((int)s.getKey(),(Double)s.getValue());
					list1.add((int) s.getKey());
					list2.add((double) s.getValue());
				}
			}
		}
		if(list1.size()>10){
			list1=list1.subList(0,10);
			list2=list2.subList(0,10);
		}
		for(int i=0;i<list1.size();i++)
			mapresult.put(list1.get(i),list2.get(i));

//		List<Map.Entry<Integer,Double>> list11=new ArrayList<>(mapresult.entrySet());
//		Collections.sort(list11, new Comparator<Map.Entry<Integer, Double>>() {
//			@Override
//			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
//				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
//			}
//		});

		return mapresult;
	}
	public Map<Object,Object> key2(double aa){
		Map<Integer,Double> map=new HashMap<>();
		Map<Object,Object> mapresult=new HashMap<>();
		HashSet hashSet=new HashSet();
		for(BabtEvlBattery babtEvlBattery:evlTaskService.evlAvgSOHBattery90()){
			hashSet.add(babtEvlBattery.getProductModeID());
		}
		Iterator iterator=hashSet.iterator();
		while(iterator.hasNext()){
			int a=(int)iterator.next();
			int count=0;
			double sohcount=0;

			for (BabtEvlBattery babtEvlBattery2 : evlTaskService.evlAvgSOHBattery90()) {
				if (babtEvlBattery2.getProductModeID()==a) {
					sohcount += babtEvlBattery2.getSOH();
					count++;
				}
			}
			map.put(a,sohcount/count);

		}

		List<Map.Entry<Integer,Double>> list=new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
			@Override
			public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
				return (int)((o2.getValue()*1000) - (o1.getValue()*1000));
			}
		});
		System.out.println(list);
		List<Integer> list1=new ArrayList<Integer>();
		List<Double> list2=new ArrayList<Double>();
		for (Map.Entry s : list)
		{
			if(aa==0){
				if((Double)s.getValue()<(aa+0.6)&&(Double)s.getValue()>=aa){
//				mapresult.put((int)s.getKey(),(Double)s.getValue());
					list1.add((int)s.getKey());
					list2.add((double)s.getValue());
				}
			}else {
				if ((Double) s.getValue() < (aa + 0.1) && (Double) s.getValue() >= aa) {
//				mapresult.put((int)s.getKey(),(Double)s.getValue());
					list1.add((int) s.getKey());
					list2.add((double) s.getValue());
				}
			}
		}
		if(list1.size()>10){
			list1=list1.subList(0,10);
			list2=list2.subList(0,10);
		}
		for(int i=0;i<list1.size();i++)
			mapresult.put(list1.get(i),list2.get(i));



		return mapresult;
	}



	
	

}
