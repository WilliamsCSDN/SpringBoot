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
	public List<BabtEvlTaskBattery> evlAvgSocCar(int id);
	public List<BabtEvlTask> evlAvgSocBattery(int id);
	public double evlAvgSoc(int id);


	//电池包评估SOC高于90%的电池包数量（车辆电池包评估+独立电池包评估）
	public List<BabtEvlReport>  evlAvgSoc90(int id);

	//电池包评估SOC在80-90%之间的电池包数量（车辆电池包评估+独立电池包评估）
	public List<BabtEvlReport>  evlAvgSoc80(int id);

	//电池包评估SOC在70-80%之间的电池包数量（车辆电池包评估+独立电池包评估）
	public List<BabtEvlReport>  evlAvgSoc70(int id);

	//电池包评估SOC在60-70%之间的电池包数量（车辆电池包评估+独立电池包评估）
	public List<BabtEvlReport>  evlAvgSoc60(int id);

	//电池包评估SOC低于60%的电池包数量（车辆电池包评估+独立电池包评估）
	public List<BabtEvlReport>  evlAvgSoc0(int id);

	//车辆电池包总评估次数
	public int carTotalEvlCount();

	//独立电池包总评估次数
	public int batteryTotalEvlCount();

	//车辆电池包评估车辆数
	public int batteryEvlCarCount();

	//独立电池包总评估电池数
	public int batteryEvlBatteryCount();

	//过去一年，从1月-12月，每个月的评估次数
	public int batteryEvlCountLastYear(String startTime,String endTime);

	//过去一年，从1月-12月，每个月的评估电池数
	public List<Integer>  batteryEvlBatteryCountLastYearCar(String startTime,String endTime);
	public List<Integer>  batteryEvlBatteryCountLastYearBattery(String startTime,String endTime);

	//车辆电池包评估SOH在90-100%之间的车辆型号TOP10，以及该车型对应的SOH
	public List<BabtEvlTask> evlAvgSOHCar90();

	//车辆电池包评估次数
	public int carBatteryEvlCount();

	//车辆电池包评估车辆数
	public int carBatteryEvlCarCount();

	//车辆电池包评估车辆数
	public int carBatteryEvlCarModelCount();

	//独立电池包评估次数
	public int dBatteryEvlCount();

	//独立电池包评估电池数
	public int dBatteryEvlBatteryCount();

	//独立电池包评估电池包型号数
	public int dBatteryEvlBatteryModelCount();

	//过去一年，从1月-12月，每个月的车辆电池包评估次数
	public int carBatteryEvlCountLastYear(String startTime,String endTime);

	//过去一年，从1月-12月，每个月的车辆电池包评估次数
	public int carBatteryEvlCarCountLastYear(String startTime,String endTime);

	//过去一年，从1月-12月，每个月的独立电池包评估次数
	public int dBatteryEvlCountLastYear(String startTime,String endTime);

	//过去一年，从1月-12月，每个月的独立电池包评估电池数
	public int dBatteryEvlBatteryCountLastYear(String startTime,String endTime);

	//评估次数前十名的车辆型号
	public List<Integer> dBatteryEvlBatteryCountLastYear();




}
