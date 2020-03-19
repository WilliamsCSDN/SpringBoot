package com.babt.stat.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.babt.stat.entity.BabtShcCarEvlRecord;
import com.babt.stat.entity.CarEvlStat;
import com.babt.stat.entity.cond.Car4StatCond;
import com.babt.stat.mapper.BabtShcCarEvlRecordDao;
import com.babt.stat.service.IBabtShcCarEvlRecordService;
import com.babt.stat.util.BabtDateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * <p>
 * 整车评估记录 服务实现类
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
@Service
public class BabtShcCarEvlRecordServiceImpl extends ServiceImpl<BabtShcCarEvlRecordDao, BabtShcCarEvlRecord> implements IBabtShcCarEvlRecordService {

	private Logger logger=Logger.getLogger(BabtShcCarEvlRecordServiceImpl.class);
	
	@Override
	public List<CarEvlStat> statCountByCarModel() {
		Date startDate=BabtDateUtil.firstDayOfoneYearAgo();
		return baseMapper.statCountByCarModel(startDate);
	}
	
	@Override
	public List<CarEvlStat>  statCountByMonth(){
		return baseMapper.statCountByMonth();
	}
	
	@Override
	public List<CarEvlStat> evlTimeConsumeByWeek() {
		return baseMapper.evlTimeConsumeByWeek();
	}

	@Override
	public List<CarEvlStat> statCountByArea() {
		return baseMapper.statCountByArea();
	}

	@Override
	public List<CarEvlStat> statCountByProvinceInCountry() {
		return baseMapper.statCountByProvinceInCountry();
	}

	@Override
	public List<CarEvlStat> statCountByCityInProvince(String provinceCode) {
		return baseMapper.statCountByCityInProvince(provinceCode);
	}

	@Override
	public List<CarEvlStat> statCountByDistrictInProvinceCity(String provinceCode, String cityCode) {
		return baseMapper.statCountByDistrictInProvinceCity(provinceCode, cityCode);
	}

	@Override
	public Integer countCity() {
		return baseMapper.countCity();
	}

	@Override
	public int countCarManufacture() {
		return baseMapper.countCarManufacture();
	}

	@Override
	public int countCarModel() {
		return baseMapper.countCarModel();
	}

	@Override
	public int countEvalCar() {
		return baseMapper.countEvalCar();
	}
	
	@Override
	public Double avgEvalTimeConsumer() {
		Date startTime=BabtDateUtil.oneWeekAgoMonday0();
		Date endTime=BabtDateUtil.oneWeekAgoSunDay24();
		//logger.info("avgEvalTimeConsumer: starTime="+startTime+";  endTime="+endTime);
		System.out.println("avgEvalTimeConsumer: starTime="+BabtDateUtil.formateHHmmss(startTime)+";  endTime="+BabtDateUtil.formateHHmmss(endTime));
		return baseMapper.avgEvalTimeConsumer(startTime, endTime);
	}

	@Override
	public List<CarEvlStat> avgMileCountByArea() {
		return	baseMapper.avgMileCountByArea();
	}

	@Override
	public Integer queryEvalCarsByCond(Car4StatCond carCond) {
		return baseMapper.queryEvalCarsByCond(carCond);
	}

	@Override
	public Double queryAvgRateByCond(Car4StatCond carCond) {
	   return baseMapper.queryAvgRateByCond(carCond);
	}

	@Override
	public Double queryAvgAgeByCond(Car4StatCond carCond) {
		 return baseMapper.queryAvgAgeByCond(carCond);
	}

	@Override
	public Double queryAvgMileByCond(Car4StatCond carCond) {
		 return baseMapper.queryAvgMileByCond(carCond);
	}
	
	

}
