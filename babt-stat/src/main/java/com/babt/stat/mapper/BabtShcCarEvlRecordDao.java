package com.babt.stat.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.babt.stat.entity.BabtShcCarEvlRecord;
import com.babt.stat.entity.CarEvlStat;
import com.babt.stat.entity.cond.Car4StatCond;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 整车评估记录 Mapper 接口
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface BabtShcCarEvlRecordDao extends BaseMapper<BabtShcCarEvlRecord> {
	//1.根据车型统计车数量TOP10(12个月内)
	@Select("select o.ModelName,count(*) as count from  babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.orderId and r.CompleteDate between #{startTime} and now() and r.Completed=3 group by CarModelId  order by count desc")
	public List<CarEvlStat> statCountByCarModel(@Param("startTime")Date startTime);
	
	//2.车辆评估数量 月曲线
	@Select("select month(CompleteDate) as month, count(*) as count from babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.orderId and r.CompleteDate between DATE_SUB(curdate(),INTERVAL 12 MONTH) and now() and r.Completed=3 group by month order by count desc")
	public List<CarEvlStat> statCountByMonth();
	        
	//3.按周统计评估耗时长
	@Select("select DATE_FORMAT(CompleteDate,'%Y年 第%u周') week, count(*) as count, avg(TIMESTAMPDIFF(MINUTE,EvlDate,completeDate)) as minutes from babt_shc_car_evl_record where Completed=3 group by week")
	public List<CarEvlStat> evlTimeConsumeByWeek();
	
	//5. 按地区统计车辆评估数量
	@Select("select  area,count(*) as count  from babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.orderId and r.Completed=3 group by area")
	public  List<CarEvlStat> statCountByArea();

	//5. 按省统计车辆评估数量
	@Select("select o.ProvinceCode as area,count(o.CarId) as count from babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.orderId and r.Completed=3 group by o.ProvinceCode")
	public  List<CarEvlStat> statCountByProvinceInCountry();

	//5. 按市统计指定省的车辆评估数量
	@Select("select o.CityCode as area, count(o.CarId) as count from babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.orderId and r.Completed=3 and o.ProvinceCode=#{provinceCode} group by o.CityCode")
	public  List<CarEvlStat> statCountByCityInProvince(@Param("provinceCode") String provinceCode);

	//5. 按区县统计指定省指定市的车辆评估数量
	@Select("select o.DistrictCode as area, count(o.CarId) as count from babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.orderId and r.Completed=3 and o.ProvinceCode=#{provinceCode} and o.CityCode=#{cityCode} group by o.DistrictCode")
	public  List<CarEvlStat> statCountByDistrictInProvinceCity(@Param("provinceCode") String provinceCode, @Param("cityCode") String cityCode);
	
	// 14. 覆盖城市数量
	@Select("select  count(DISTINCT o.CityCode) as citycount  from  babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.OrderId and r.Completed=3")
	public  Integer countCity();

	//15. 二手车厂商数量 
	@Select("select  count(DISTINCT o.BPManufacturer) as manufacturer  from  babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.OrderId and r.Completed=3")
	public int countCarManufacture() ;

	//16. 经过评估的二手车车型数量
	@Select("select  count(DISTINCT o.CarModelId) as carModel  from  babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.OrderId and r.Completed=3")
	public int countCarModel();

	//17. 经过评估的评估二手车数量
	@Select("select  count(DISTINCT o.CarId) as carModel  from  babt_shc_car_evl_order o, babt_shc_car_evl_record r where o.id=r.OrderId and r.Completed=3")
	public int countEvalCar();	
	
	@Select("select  avg(timestampdiff(MINUTE,EvlDate,completeDate))  AS avgTimeConsume  from babt_shc_car_evl_record where completeDate between #{startTime} and #{endTime} and Completed=3")
	public Double avgEvalTimeConsumer(@Param("startTime")Date startTime,@Param("endTime")Date endTime);
	
	@Select("select avg(Mileage) as avgMileage, count(r.id) as count,area as area from babt_shc_car_evl_record r,babt_shc_car_evl_order o where r.orderId=o.id group by area; ")
	List<CarEvlStat> avgMileCountByArea(); 
	
	public Integer queryEvalCarsByCond(Car4StatCond carCond);
	
	
	public Double queryAvgRateByCond(Car4StatCond carCond);
	
	public Double queryAvgAgeByCond(Car4StatCond carCond);
	
	
	public Double queryAvgMileByCond(Car4StatCond carCond);
}
