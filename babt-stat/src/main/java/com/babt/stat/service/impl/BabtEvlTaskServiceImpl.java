package com.babt.stat.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.babt.stat.entity.*;
import org.springframework.stereotype.Service;

import com.babt.stat.mapper.BabtEvlTaskDao;
import com.babt.stat.service.IBabtEvlTaskService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@Service
public class BabtEvlTaskServiceImpl extends ServiceImpl<BabtEvlTaskDao, BabtEvlTask> implements IBabtEvlTaskService {
	
	@Override
	public List<BatteryEvlStat> countBatteryByArea(){
		return baseMapper.countByArea();
	}

	@Override
	public List<BatteryEvlStat> countBatteryByMonth() {
		Date startMonth=BabtDateUtil.firstDayOfoneYearAgo();
		return baseMapper.countBatteryByMonth(startMonth);
	}

	//统计电池总容量，剩余容量
	@Override
	public  BatteryCapStat countBatteryCapAndSup(){
		return baseMapper.countBatteryCapAndSup();
	}
	
	// 按型号 统计5年左右(60-62个月)电池平均剩余top10：算法评估部分
	@Override
	public  List<BatteryCapStat> count5yearCsByModel() {
		return baseMapper.count5yearCsByModel();
	}

	@Override
	public List<Integer> evalBatteryCount() {
		return baseMapper.evalBatteryCount();
	}

	@Override
	public List<CarEvlStat> countCarOfEvalBatteryByModel() {
		return baseMapper.countCarOfEvalBatteryByModel();
	}
	
	@Override
	public List<CarEvlStat> avgBatteryCapByAge() {
		return baseMapper.avgBatteryCapByAge();
	}

	@Override
	public int countAll() {
		return baseMapper.countAll();
	}

	@Override
	public int countByRecordIdNull() {
		return baseMapper.countByRecordIdNull();
	}

	@Override
	public BatterySurplusStat surplusSum() {
		return baseMapper.surplusSum();
	}

	@Override
	public int totalEvlCount(){return baseMapper.totalEvlCount();}

	@Override
	public List<BabtMcBattery> totalBatteryEvlCountCar(){return baseMapper.totalBatteryEvlCountCar();}
	public List<BabtMcBattery> totalBatteryEvlCountBattery(){return baseMapper.totalBatteryEvlCountBattery();}

	@Override
	public int totalBatteryEvlCapacityCount(int id){return baseMapper.totalBatteryEvlCapacityCount(id);}

	@Override
	public List<BabtEvlTaskBattery> evlAvgSocCar(int id){return baseMapper.evlAvgSocCar(id);}

	@Override
	public List<BabtEvlTask> evlAvgSocBattery(int id){return baseMapper.evlAvgSocBattery(id);}

	@Override
	public double evlAvgSoc(int id){return baseMapper.evlAvgSoc(id);}

	@Override
	public List<BabtEvlReport> evlAvgSoc90(int id){return baseMapper.evlAvgSoc90(id);}

	@Override
	public List<BabtEvlReport>  evlAvgSoc80(int id){return baseMapper.evlAvgSoc80(id);}

	@Override
	public List<BabtEvlReport>  evlAvgSoc70(int id){return baseMapper.evlAvgSoc70(id);}

	@Override
	public List<BabtEvlReport>  evlAvgSoc60(int id){return baseMapper.evlAvgSoc60(id);}

	@Override
	public List<BabtEvlReport>  evlAvgSoc0(int id){return baseMapper.evlAvgSoc0(id);}

	@Override
	public int carTotalEvlCount(){return baseMapper.carTotalEvlCount();}

	@Override
	public int batteryTotalEvlCount(){return baseMapper.batteryTotalEvlCount();}

	@Override
	public int batteryEvlCarCount(){return baseMapper.batteryEvlCarCount();}

	@Override
	public int batteryEvlBatteryCount(){return baseMapper.batteryEvlBatteryCount();}

	@Override
	public int batteryEvlCountLastYear(String startTime,String endTime){return baseMapper.batteryEvlCountLastYear(startTime,endTime);}

	@Override
	public List<Integer>  batteryEvlBatteryCountLastYearCar(String startTime,String endTime){return baseMapper.batteryEvlBatteryCountLastYearCar(startTime,endTime);}

	@Override
	public List<Integer>  batteryEvlBatteryCountLastYearBattery(String startTime,String endTime){return baseMapper.batteryEvlBatteryCountLastYearBattery(startTime,endTime);}

	@Override
	public List<BabtEvlCar> evlAvgSOHCar90(){return baseMapper.evlAvgSOHCar90();}

	@Override
	public int carBatteryEvlCount(){return baseMapper.carBatteryEvlCount();}

	@Override
	public int carBatteryEvlCarCount(){return baseMapper.carBatteryEvlCarCount();}

	@Override
	public int carBatteryEvlCarModelCount(){return baseMapper.carBatteryEvlCarModelCount();}

	@Override
	public int dBatteryEvlCount(){return baseMapper.dBatteryEvlCount();}

	@Override
	public int dBatteryEvlBatteryCount(){return baseMapper.dBatteryEvlBatteryCount();}

	@Override
	public int dBatteryEvlBatteryModelCount(){return baseMapper.dBatteryEvlBatteryModelCount();}

	@Override
	public int carBatteryEvlCountLastYear(String startTime,String endTime){return baseMapper.carBatteryEvlCountLastYear(startTime, endTime);}

	@Override
	public int carBatteryEvlCarCountLastYear(String startTime,String endTime){return baseMapper.carBatteryEvlCarCountLastYear(startTime, endTime);}

	@Override
	public int dBatteryEvlCountLastYear(String startTime,String endTime){return baseMapper.dBatteryEvlCountLastYear(startTime, endTime);}

	@Override
	public int dBatteryEvlBatteryCountLastYear(String startTime,String endTime){return baseMapper.dBatteryEvlBatteryCountLastYear(startTime, endTime);}

	@Override
	public List<Integer> carBatteryEvlCarModelCountTop(){return baseMapper.carBatteryEvlCarModelCountTop();}

	@Override
	public int carBatteryEvlManufacturerCount(){return baseMapper.carBatteryEvlManufacturerCount();}

	@Override
	public int dBatteryEvlManufacturerCount(){return baseMapper.dBatteryEvlManufacturerCount();}

	@Override
	public List<BabtEvlBattery> evlAvgSOHBattery90(){return baseMapper.evlAvgSOHBattery90();}

	@Override
	public List<String> carBatteryEvlManufacturerCountTop(){ return baseMapper.carBatteryEvlManufacturerCountTop();}

	@Override
	public int carBatteryEvlManufacturerCountTOPCount(String NameCN){return baseMapper.carBatteryEvlManufacturerCountTOPCount(NameCN);}

	@Override
	public List<BabtEvlCarManufacturer> carBatteryEvlSohManufacturerCountTop(){return baseMapper.carBatteryEvlSohManufacturerCountTop();}

	@Override
	public List<Integer> dBatteryEvlCarModelCountTop(){return baseMapper.dBatteryEvlCarModelCountTop();}

	@Override
	public List<String> dBatteryEvlManufacturerCountTop(){return baseMapper.dBatteryEvlManufacturerCountTop();}
	@Override
	public int dBatteryEvlManufacturerCountTopCount(String BatteryManufacturer){return baseMapper.dBatteryEvlManufacturerCountTopCount(BatteryManufacturer);}

	@Override
	public List<BabtEvlBatteryManufacturer> dBatteryEvlSohManufacturerCountTop(){return  baseMapper.dBatteryEvlSohManufacturerCountTop();}


}


