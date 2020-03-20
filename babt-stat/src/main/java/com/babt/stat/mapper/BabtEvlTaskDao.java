package com.babt.stat.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.babt.stat.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author denglianyong
 * @since 2018-04-06
 */
public interface BabtEvlTaskDao extends BaseMapper<BabtEvlTask> {
	
	//4.2 按地区统计电池数量：算法评估部分
	@Select("select count(t.id) as count,area from babt_evl_task  t,babt_mc_car  c where t.RecordId is null and t.CarId=c.id and t.status=4 group by Area")
	public List<BatteryEvlStat> countByArea();
	
	//6. 按月份统计电池数量：算法评估部分
	@Select("select count(id) as count, month(EndTime) as month from babt_evl_task  where RecordId is null  and Status=4 and EndTime between #{startMonth} and now()  group by month")
	public List<BatteryEvlStat> countBatteryByMonth(@Param("startMonth")Date startMonth);
	
	//7. 统计电池总容量，剩余容量：算法评估部分
	@Select("select  sum(Capacity*SOH) as sumSurplus, sum(Capacity) as sumCapcity from babt_evl_task t,babt_mc_car c,babt_mc_battery b ,babt_evl_report report where t.CarId=c.id  and c.BatteryId=b.id and report.TaskId=t.id and t.status=4 and t.RecordId is null")
	public  BatteryCapStat countBatteryCapAndSup();

	// 8. 按型号 统计5年左右(60-62个月)电池平均剩余top10：算法评估部分
	@Select("select m.Name as modelName, avg(report.SOH) as avgSurplus,count(t.id) as count from babt_evl_task t,babt_mc_car c,babt_mc_battery b, babt_mc_battery_model m, babt_evl_report report where t.CarId=c.id and c.BatteryId=b.id and b.ProductModeID=m.id and report.TaskId=t.id and t.status=4 and t.RecordId is null and TIMESTAMPDIFF(MONTH,b.ManufactureDate,t.EndTime) between 60 and 62 group by b.ProductModeID  order by avgSurplus desc")
	public List<BatteryCapStat> count5yearCsByModel();

	//11. 评估电池数：算法评估部分
	@Select("select c.BatteryId from babt_evl_task t, babt_mc_car c where t.CarId=c.id and t.RecordId is null and status=4 group by BatteryId")
	public List<Integer> evalBatteryCount();
	
	//12. 做过电池评估的车辆 ，按型号group 统计每种型号的数目 TOP10：算法评估部分
	@Select("select p.name as ModelName, count(t.CarId) as count  from babt_evl_task t, babt_mc_car c,babt_mc_product_model  p where  RecordId is null and t.CarId=c.id and p.id=c.CarModelId and t.status=4 group by c.CarModelId order by count desc")
	public List<CarEvlStat> countCarOfEvalBatteryByModel();
	
	//13. 根据车龄 按月 统计电池平均余量
	@Select("select TIMESTAMPDIFF(MONTH,BuyDatetime,t.EndTime) as age, AVG(SOH) as avgSurplusCap,count(t.id) as count  from babt_evl_task t, babt_mc_car c, babt_evl_report r where t.CarId=c.id and r.TaskId=t.id and t.RecordId is null and t.Status=4 GROUP BY age order by age limit 96")
	public List<CarEvlStat> avgBatteryCapByAge();
	
	//18. 大数据评估比重（算法电池评估占总评估的比率）：分子
	@Select("select count(id) as count from  babt_evl_task where status=4")
	public int countAll();
	
	//18. 大数据评估比重（算法电池评估占总评估的比率）：分母一号
	@Select("select count(id) as count from babt_evl_task where recordId is null and status=4")
	public int countByRecordIdNull();
	
	//19.所有电池余能总和:算法评估部分
	@Select("select sum(b.Capacity*report.SOH) as surplusSum, sum(report.SOH) as sohSum, count(*) as batteryCount from babt_evl_task t, babt_evl_report report, babt_mc_car c ,babt_mc_battery b where t.recordid is null and t.status=4 and report.TaskId=t.id and t.CarId=c.id and c.BatteryId=b.id")
	public BatterySurplusStat surplusSum();



	//20.总评估次数（车辆电池包评估+独立电池包评估）
	@Select("select count(*) from babt_evl_task where Status=4 and t.RecordId is null")
	public int totalEvlCount();

	//21.总评估电池数（车辆电池包评估+独立电池包评估）
	@Select("select b.ID from babt_evl_task t,babt_mc_car c,babt_mc_battery b  where t.CarId=c.id  and c.BatteryId=b.id and t.status=4 and t.RecordId is null")
	public List<BabtMcBattery> totalBatteryEvlCountCar();
	@Select("select b.ID from babt_evl_task t,babt_mc_battery b  where t.BatteryId=b.id and t.status=4 and t.RecordId is null")
	public List<BabtMcBattery> totalBatteryEvlCountBattery();

	//22.电池包评估总量（车辆电池包评估+独立电池包评估）
	@Select("select Capacity from babt_mc_battery where id=#{id}")
	public int totalBatteryEvlCapacityCount(@Param("id") int id);

	//23.电池包评估平均SOC（车辆电池包评估+独立电池包评估）
	    //车辆
	@Select("select t.ID as taskID,t.EndTime,b.ID as batteryID,t.CarId,c.CarModelId from babt_evl_task t,babt_mc_car c,babt_mc_battery b where t.CarId=c.ID and c.BatteryId=b.ID and b.ID=${id} and status=4 and t.RecordId is null  ORDER BY EndTime desc limit 1")
	public List<BabtEvlTaskBattery> evlAvgSocCar(@Param("id") int id);
	    //电池
	@Select("select t.ID,t.EndTime,t.CarId,t.BatteryId from babt_evl_task t,babt_mc_battery b where t.BatteryId=b.ID and b.ID=${id} and status=4 and t.RecordId is null  ORDER BY EndTime desc limit 1")
	public List<BabtEvlTask> evlAvgSocBattery(@Param("id") int id);
	@Select("select r.SOH from babt_evl_task t,babt_evl_report r where t.ID=r.TaskId and t.ID=${id}")
	public double evlAvgSoc(@Param("id") int id);


	//24.电池包评估SOC高于90%的电池包数量（车辆电池包评估+独立电池包评估）
	@Select("select r.SOH from babt_evl_task t,babt_evl_report r where t.ID=r.TaskId and t.ID=${id} and r.SOH>0.9")
	public List<BabtEvlReport>  evlAvgSoc90(@Param("id") int id);

	//25.电池包评估SOC在80-90%之间的电池包数量（车辆电池包评估+独立电池包评估）
	@Select("select r.SOH from babt_evl_task t,babt_evl_report r where t.ID=r.TaskId and t.ID=${id} and r.SOH>0.8 and r.SOH<=0.9")
	public List<BabtEvlReport>  evlAvgSoc80(@Param("id") int id);

	//26.电池包评估SOC在70-80%之间的电池包数量（车辆电池包评估+独立电池包评估）
	@Select("select r.SOH from babt_evl_task t,babt_evl_report r where t.ID=r.TaskId and t.ID=${id} and r.SOH>0.7 and r.SOH<=0.8")
	public List<BabtEvlReport>  evlAvgSoc70(@Param("id") int id);

	//27.电池包评估SOC在60-70%之间的电池包数量（车辆电池包评估+独立电池包评估）
	@Select("select r.SOH from babt_evl_task t,babt_evl_report r where t.ID=r.TaskId and t.ID=${id} and r.SOH>0.6 and r.SOH<=0.7")
	public List<BabtEvlReport>  evlAvgSoc60(@Param("id") int id);

	//28.电池包评估SOC低于60%的电池包数量（车辆电池包评估+独立电池包评估）
	@Select("select r.SOH from babt_evl_task t,babt_evl_report r where t.ID=r.TaskId and t.ID=${id} and r.SOH<=0.6")
	public List<BabtEvlReport>  evlAvgSoc0(@Param("id") int id);

	//29.车辆电池包总评估次数
	@Select("select count(CarId) from babt_evl_task where status=4 and RecordId is null")
	public int carTotalEvlCount();

	//30.独立电池包总评估次数
	@Select("select count(BatteryId) from babt_evl_task where status=4 and RecordId is null")
	public int batteryTotalEvlCount();

	//31.车辆电池包评估车辆数
	@Select("select count(DISTINCT CarId) from babt_evl_task where status=4 and RecordId is null")
	public int batteryEvlCarCount();

	//32.独立电池包总评估电池数
	@Select("select count(DISTINCT BatteryId) from babt_evl_task where status=4 and RecordId is null")
	public int batteryEvlBatteryCount();

	//33.过去一年，从1月-12月，每个月的评估次数
	@Select("select count(ID) from babt_evl_task where status=4 and t.RecordId is null and EndTime between #{startTime} and #{endTime}")
	public int batteryEvlCountLastYear(@Param("startTime") String startTime,@Param("endTime") String endTime);

	//34.过去一年，从1月-12月，每个月的评估电池数
	@Select("select b.ID from babt_evl_task t,babt_mc_car c,babt_mc_battery b where t.CarId=c.ID and c.BatteryId=b.ID and status=4 and t.RecordId is null and t.EndTime between #{startTime} and #{endTime}")
	public List<Integer> batteryEvlBatteryCountLastYearCar(@Param("startTime") String startTime,@Param("endTime") String endTime);
	@Select("select t.BatteryId from babt_evl_task t,babt_mc_battery b where t.BatteryId=b.ID and t.status=4 and t.RecordId is null and t.EndTime between #{startTime} and #{endTime}")
	public List<Integer> batteryEvlBatteryCountLastYearBattery(@Param("startTime") String startTime,@Param("endTime") String endTime);

	//35.车辆电池包评估SOH在90-100%之间的车辆型号TOP10，以及该车型对应的SOH
	@Select("")
	public List<BabtEvlTask> evlAvgSOHCar90();

}
