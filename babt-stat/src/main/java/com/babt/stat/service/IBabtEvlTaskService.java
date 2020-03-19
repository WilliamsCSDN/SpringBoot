package com.babt.stat.service;

import java.util.List;
import java.util.Map;

import com.babt.stat.entity.*;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface IBabtEvlTaskService extends IService<BabtEvlTask> {
	
	public List<BatteryEvlStat> countBatteryByArea();
	
	
	public List<BatteryEvlStat>  countBatteryByMonth();
	
	
	//统计电池总容量，剩余容量
	public  BatteryCapStat countBatteryCapAndSup();
	
	//按型号 统计5年左右(60-62个月)电池平均剩余top10：算法评估部分
	public  List<BatteryCapStat> count5yearCsByModel();
	
	//  评估过的电池数量
	public List<Integer> evalBatteryCount();
	
	// 做过电池评估的车辆 ，按型号group 统计每种型号的数目
	public List<CarEvlStat> countCarOfEvalBatteryByModel();
	
	// 根据车龄 统计电池平均余量
	public List<CarEvlStat> avgBatteryCapByAge();
	
	public int countAll();
	
	public int countByRecordIdNull();
	
	
	//所有电池余能总和
	public BatterySurplusStat surplusSum();

	//总评估次数
	public int totalEvlCount();

	//总电池评估数
	public List<BabtMcBattery> totalBatteryEvlCountCar();
	public List<BabtMcBattery> totalBatteryEvlCountBattery();

	//总电池评估容量
	public int totalBatteryEvlCapacityCount(int id);

	//电池包评估平均SOC（车辆电池包评估+独立电池包评估）
	public List<BabtEvlTaskBattery> evlAvgSoc();
	public int evlAvgSoc1(int id);
	public double evlAvgSoc2(int id);
	public List<BabtEvlTask> evlAvgSoc3();
	public List<BabtEvlTask> evlAvgSoc4(int id);

	//电池包评估SOC高于90%的电池包数量（车辆电池包评估+独立电池包评估）
	public int evlAvgSoc90();

	//电池包评估SOC在80-90%之间的电池包数量（车辆电池包评估+独立电池包评估）
	public int evlAvgSoc80();

	//电池包评估SOC在70-80%之间的电池包数量（车辆电池包评估+独立电池包评估）
	public int evlAvgSoc70();

	//电池包评估SOC在60-70%之间的电池包数量（车辆电池包评估+独立电池包评估）
	public int evlAvgSoc60();

	//电池包评估SOC低于60%的电池包数量（车辆电池包评估+独立电池包评估）
	public int evlAvgSoc0();

	//车辆电池包总评估次数
	public int carTotalEvlCount();

	//独立电池包总评估次数
	public int batteryTotalEvlCount();




}
