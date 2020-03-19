package com.babt.stat.service;

import java.util.List;

import com.babt.stat.entity.BabtShcCarEvlRecord;
import com.babt.stat.entity.CarEvlStat;
import com.babt.stat.entity.cond.Car4StatCond;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 整车评估记录 服务类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface IBabtShcCarEvlRecordService extends IService<BabtShcCarEvlRecord> {
	
	public List<CarEvlStat>  statCountByCarModel(); 
	
	public List<CarEvlStat>  statCountByMonth();
	
	public List<CarEvlStat>  statCountByArea();
	
	public List<CarEvlStat> statCountByProvinceInCountry();

	public List<CarEvlStat> statCountByCityInProvince(String provinceCode);

	public List<CarEvlStat> statCountByDistrictInProvinceCity(String provinceCode, String cityCode);
	
	public List<CarEvlStat>  evlTimeConsumeByWeek();
	
	
	// 业务覆盖了多少城市
	public  Integer countCity();
	

	//  覆盖多少厂商
	public int countCarManufacture();
	

	//  覆盖多少车型
	public int countCarModel();

	//评估过的车辆数
	public int countEvalCar();	
	
	
	// 统计平均每周评估耗时
	public Double avgEvalTimeConsumer();
	
	public List<CarEvlStat> avgMileCountByArea();
	
	
	
	public Integer queryEvalCarsByCond(Car4StatCond carCond);
	
	
	public Double queryAvgRateByCond(Car4StatCond carCond);
	
	public Double queryAvgAgeByCond(Car4StatCond carCond);
	
	
	public Double queryAvgMileByCond(Car4StatCond carCond);
	
	
	

}
