package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtShcBatteryEvlRecord;
import com.babt.stat.entity.BatteryCapStat;
import com.babt.stat.entity.BatteryEvlStat;
import com.babt.stat.entity.BatterySurplusStat;
import com.babt.stat.entity.CarEvlStat;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 电池评估记录 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface IBabtShcBatteryEvlRecordService extends IService<BabtShcBatteryEvlRecord> {
	
	// 按地区统计二手电池数量
	public List<BatteryEvlStat> countBatteryByArea();
	
	// 按省统计二手电池数量
	public List<BatteryEvlStat> countBatteryByProvinceInCountry();
	
	// 按市统计指定省的二手电池数量 
	public List<BatteryEvlStat> countBatteryByCityInProvince(String provinceCode);
	
	// 按区县统计指定省指定市的二手电池数量 
	public List<BatteryEvlStat> countBatteryByDistrictInProvinceCity(String provinceCode, String cityCode);
	
	// 按月份统计电池数量
	public List<BatteryEvlStat> countByMonth();
	
	
	//统计电池总容量，剩余容量
	public BatteryCapStat countCapAndSup();
	
	// 统计5年左右
	public List<BatteryCapStat> count5yearCsByModel();
	
	// 统计电池厂商数量
	public int  countManufacturer();
	
	//统计电池有多少种型号
	public int countModel();
	
	//评估完成的电池数
	public List<Integer> evalBatteryCount();
	
	//做过电池评估的车辆 ，按型号group 统计每种型号的数目 TOP10
	public  List<CarEvlStat> countCarOfEvalBatteryByModel();
	
	// 根据车龄 统计电池平均余量
	public List<CarEvlStat> avgBatteryCapByAge();

	//评估完成的电池次数
	public int evalBatteryTimes();
	
	
	//所有电池余能总和
	public BatterySurplusStat surplusSum();
	
	
	
}
