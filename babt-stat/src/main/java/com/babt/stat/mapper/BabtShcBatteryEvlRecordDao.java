package com.babt.stat.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.babt.stat.entity.BabtShcBatteryEvlRecord;
import com.babt.stat.entity.BatteryCapStat;
import com.babt.stat.entity.BatteryEvlStat;
import com.babt.stat.entity.BatterySurplusStat;
import com.babt.stat.entity.CarEvlStat;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 电池评估记录 Mapper 接口
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface BabtShcBatteryEvlRecordDao extends BaseMapper<BabtShcBatteryEvlRecord> {
	
	//4.1 按地区统计电池数量：二手车评估部分
	@Select("select count(r.id) as count,area from  babt_shc_battery_evl_record  r , babt_shc_car_evl_order  o  where r.orderid=o.id and  r.Completed=3 group by area")
	public  List<BatteryEvlStat> countByArea();
	
	// 4. 按省统计二手电池数量
	@Select("select o.ProvinceCode as area, count(r.BatteryId) as count from babt_shc_battery_evl_record r, babt_shc_car_evl_order o  where r.orderid=o.id and  r.Completed=3 group by o.ProvinceCode")
	public List<BatteryEvlStat> countByProvinceInCountry();
	
	// 4. 按市统计指定省的二手电池数量 
	@Select("select  o.CityCode as area, count(r.BatteryId) as count from babt_shc_battery_evl_record r, babt_shc_car_evl_order o  where r.orderid=o.id and r.Completed=3 and o.ProvinceCode=#{provinceCode} group by o.CityCode")
	public List<BatteryEvlStat> countByCityInProvince(@Param("provinceCode") String provinceCode);
	
	// 4. 按区县统计指定省指定市的二手电池数量 
	@Select("select  o.DistrictCode as area, count(r.BatteryId) as count from babt_shc_battery_evl_record r, babt_shc_car_evl_order o  where r.orderid=o.id and  r.Completed=3 and o.ProvinceCode=#{provinceCode} and o.CityCode=#{cityCode} group by o.DistrictCode")
	public List<BatteryEvlStat> countByDistrictInProvinceCity(@Param("provinceCode") String provinceCode, @Param("cityCode") String cityCode);
	
	// 6. 按月份统计电池数量：二手车评估部分
	@Select("select  count(id) as count,month(CompleteDate) as  month from  babt_shc_battery_evl_record where Completed=3 and CompleteDate between #{startMonth} and now() group by month")
	public List<BatteryEvlStat> countByMonth(@Param("startMonth")Date startMonth);
	
	//7. 统计电池总容量，剩余容量：二手车评估部分
	@Select("select  sum(Capacity*PFSOH) as sumSurplus, sum(Capacity) as sumCapcity from babt_shc_battery_evl_record r,babt_mc_battery b where r.batteryid=b.id and r.Completed=3")
	public BatteryCapStat countCapAndSup() ;
	
	// 8. 按型号 统计5年左右(60-62个月)电池平均剩余top10：二手车评估部分
	@Select("select m.Name as modelName, avg(r.PFSOH) as avgSurplus,count(r.id) as count from babt_shc_battery_evl_record r, babt_mc_battery b, babt_mc_battery_model m  where r.batteryid=b.id and b.ProductModeID=m.id and r.Completed=3 and TIMESTAMPDIFF(MONTH,b.ManufactureDate,r.CompleteDate) between 60 and 62 group by b.ProductModeID  order by avgSurplus desc")
	public List<BatteryCapStat> count5yearCsByModel();

	//9. 做过评估的电池厂商数
	@Select("select  count(DISTINCT BatteryManufacturer) as count from babt_mc_battery b ,babt_shc_battery_evl_record  r where r.BatteryId=b.id and r.Completed=3")
	public int countManufacturer();
	
	//10. 统计做过评估电池有多少种型号
	@Select("select  count(DISTINCT  b.ProductModeID)  as count from babt_mc_battery b ,babt_shc_battery_evl_record  r where r.BatteryId=b.id and r.Completed=3")
	public int countModel() ;
	
	//11. 评估电池数：二手车评估部分 
	@Select("select BatteryId from babt_shc_battery_evl_record where Completed=3 group by BatteryId")
	public List<Integer> evalBatteryCount();
	
	//12. 做过电池评估的车辆 ，按型号group 统计每种型号的数目 TOP10：二手车评估部分
	@Select("select o.ModelName as ModelName, count(o.CarId) as count from  babt_shc_car_evl_order o, babt_shc_battery_evl_record r  where o.ID=r.BatteryId and r.Completed=3  group by o.CarModelId order by count desc")
	public List<CarEvlStat> countCarOfEvalBatteryByModel();

	//13. 根据车龄 按月 统计电池平均余量
	@Select("select TIMESTAMPDIFF(MONTH,BuyDatetime,r.CompleteDate) as age, AVG(PFSOH) as avgSurplusCap, count(r.id) as count from babt_shc_car_evl_order o, babt_shc_battery_evl_record r, babt_mc_battery  b  where r.OrderId=o.id and o.batteryid=b.id and r.Completed=3 GROUP BY age order by age limit 96")
	public List<CarEvlStat> avgBatteryCapByAge();

	//18. 评估电池数：二手车评估部分 
	@Select("select count(id) as count from babt_shc_battery_evl_record where Completed=3")
	public int evalBatteryTimes();
	
	//19.所有电池余能总和:二手车评估部分 
	@Select("select sum(Capacity*PFSOH) as surplusSum, sum(PFSOH) as sohSum, count(*) as batteryCount from babt_mc_battery b,babt_shc_battery_evl_record br where br.BatteryId=b.id and br.Completed=3")
	public BatterySurplusStat surplusSum();
	

}
