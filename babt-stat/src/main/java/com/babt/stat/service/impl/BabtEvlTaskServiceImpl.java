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
	public List<BabtEvlTaskBattery> evlAvgSoc(){return baseMapper.evlAvgSoc();}
	public int evlAvgSoc1(int id){return baseMapper.evlAvgSoc1(id);}
	public double evlAvgSoc2(int id){return baseMapper.evlAvgSoc2(id);}
	public List<BabtEvlTask> evlAvgSoc3(){return baseMapper.evlAvgSoc3();}
	public List<BabtEvlTask> evlAvgSoc4(int id){return baseMapper.evlAvgSoc4(id);}

	@Override
	public int evlAvgSoc90(){return baseMapper.evlAvgSoc90();}

	@Override
	public int evlAvgSoc80(){return baseMapper.evlAvgSoc80();}

	@Override
	public int evlAvgSoc70(){return baseMapper.evlAvgSoc70();}

	@Override
	public int evlAvgSoc60(){return baseMapper.evlAvgSoc60();}

	@Override
	public int evlAvgSoc0(){return baseMapper.evlAvgSoc0();}

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

}


