package com.babt.stat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtShcBatteryEvlRecord;
import com.babt.stat.entity.BatteryCapStat;
import com.babt.stat.entity.BatteryEvlStat;
import com.babt.stat.entity.BatterySurplusStat;
import com.babt.stat.entity.CarEvlStat;
import com.babt.stat.mapper.BabtShcBatteryEvlRecordDao;
import com.babt.stat.service.IBabtShcBatteryEvlRecordService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 电池评估记录 服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@Service
public class BabtShcBatteryEvlRecordServiceImpl extends ServiceImpl<BabtShcBatteryEvlRecordDao, BabtShcBatteryEvlRecord> implements IBabtShcBatteryEvlRecordService {

	@Override
	public List<BatteryEvlStat> countBatteryByArea() {
		return baseMapper.countByArea();
	}
	
	// 按省统计二手电池数量
	@Override
	public List<BatteryEvlStat> countBatteryByProvinceInCountry() {
		return baseMapper.countByProvinceInCountry();
	}
	
	// 按市统计指定省的二手电池数量 
	@Override
	public List<BatteryEvlStat> countBatteryByCityInProvince(String provinceCode) {
		return baseMapper.countByCityInProvince(provinceCode);
	}

	// 按区县统计指定省指定市的二手电池数量 
	@Override
	public List<BatteryEvlStat> countBatteryByDistrictInProvinceCity(String provinceCode, String cityCode) {
		return baseMapper.countByDistrictInProvinceCity(provinceCode, cityCode);
	}

	// 按月份统计电池数量
	@Override
	public List<BatteryEvlStat> countByMonth(){
		
		Date startMonth=BabtDateUtil.firstDayOfoneYearAgo();
		return baseMapper.countByMonth(startMonth);
	}
	
	@Override
	public BatteryCapStat countCapAndSup() {
		return baseMapper.countCapAndSup();
	}

	@Override
	public List<BatteryCapStat> count5yearCsByModel() {
		return baseMapper.count5yearCsByModel();
	}

	@Override
	public int countManufacturer() {
		return baseMapper.countManufacturer();
	}

	@Override
	public int countModel() {
		return baseMapper.countModel();
	}

	@Override
	public List<Integer> evalBatteryCount() {
		return baseMapper.evalBatteryCount();
	}

	// 做过电池评估的车辆 ，按型号group 统计每种型号的数目
	@Override
	public  List<CarEvlStat> countCarOfEvalBatteryByModel(){
		return baseMapper.countCarOfEvalBatteryByModel();
	}

	@Override
	public List<CarEvlStat> avgBatteryCapByAge() {
		return baseMapper.avgBatteryCapByAge();
	}

	@Override
	public int evalBatteryTimes() {
		return baseMapper.evalBatteryTimes();
	}

	@Override
	public BatterySurplusStat surplusSum() {
		return baseMapper.surplusSum();
	}
}
