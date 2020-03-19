package com.babt.stat.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.babt.stat.entity.BabtAreaCode;
import com.babt.stat.entity.BabtStAvgEvalTimeConsumer;
import com.babt.stat.entity.BabtStGoeMonthCity;
import com.babt.stat.entity.BabtStGoeMonthDistrict;
import com.babt.stat.entity.BabtStGoeMonthProvince;
import com.babt.stat.entity.BabtStGoeWeekCity;
import com.babt.stat.entity.BabtStGoeWeekDistrict;
import com.babt.stat.entity.BabtStGoeWeekProvince;
import com.babt.stat.service.IBabtShcCarEvlOrderService;
import com.babt.stat.service.IBabtShcCarEvlRecordService;
import com.babt.stat.service.IBabtStAvgEvalTimeConsumerService;
import com.babt.stat.service.IBabtStGoeMonthCityService;
import com.babt.stat.service.IBabtStGoeMonthDistrictService;
import com.babt.stat.service.IBabtStGoeMonthProvinceService;
import com.babt.stat.service.IBabtStGoeWeekCityService;
import com.babt.stat.service.IBabtStGoeWeekDistrictService;
import com.babt.stat.service.IBabtStGoeWeekProvinceService;
import com.babt.stat.util.BabtDateUtil;

@Component
public class QuartzService {
	/**
	 *  一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。
		按顺序依次为
		秒（0~59）
		分钟（0~59）
		小时（0~23）
		天（月）（0~31，但是你需要考虑你月的天数）
		月（0~11）
		天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
		7.年份（1970－2099）
	 * 
	 * 
	 */
	Logger logger=Logger.getLogger(QuartzService.class);

	@Autowired
	private IBabtShcCarEvlRecordService carEvlRecordService;

	@Autowired
	private IBabtStAvgEvalTimeConsumerService avgEvalTimeConsumerService;
	
	
	@Autowired
	private IBabtShcCarEvlOrderService carEvlOrderService;
	
	@Autowired
	private  IBabtShcCarEvlOrderService orderService;

	@Autowired
	private IBabtStGoeMonthProvinceService goeMonthProvinceService;
	
	@Autowired
	private IBabtStGoeMonthCityService goeMonthCityService;
	
	@Autowired
	private IBabtStGoeMonthDistrictService goeMonthDistrictService;
	
	@Autowired
	private IBabtStGoeWeekProvinceService goeWeekProvinceService;
	
	@Autowired
	private IBabtStGoeWeekCityService goeWeekCityService;
	
	@Autowired
	private IBabtStGoeWeekDistrictService goeWeekDistrictService;

	private Integer initMonthProvinceFlag = 0;
	
	private Integer initMonthCityFlag = 0;
	
	private Integer initMonthDistrictFlag = 0;
	
	private Integer initWeekProvinceFlag = 0;
	
	private Integer initWeekCityFlag = 0;
	
	private Integer initWeekDistrictFlag = 0;
	
	@Scheduled(cron = "0/10 * *  * * ? ")
	public void timerToNow() {
		System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

	@Scheduled(cron = "0 0 3 * * 1  ")
	public void avgTimeConsume1WeekAgo() {
		// 上周的记录是否已经存在
		String mondayOp = BabtDateUtil.formateDay(BabtDateUtil.getThisWeekMonday());

		boolean exist = avgEvalTimeConsumerService.isExistOneWeekAgo(mondayOp);
		if (exist) {
			//logger.error("avgTimeConsume1WeekAgo: mondayOp=" + mondayOp + "  already exist; return ");
			return;
		}

		Double davgTimeConsume = carEvlRecordService.avgEvalTimeConsumer();
		double avgTimeConsume = 0;
		if (davgTimeConsume != null) {
			avgTimeConsume = (double) davgTimeConsume;
		}

		BabtStAvgEvalTimeConsumer stat = new BabtStAvgEvalTimeConsumer();
		stat.setAvgTimeConsumer((int) avgTimeConsume);
		stat.setMondayOp(mondayOp);
		stat.insert();
	}

	// 每个月一号生成上个月的数据
	//@Scheduled(cron = "0 0 4 1 * *  ")
	@Scheduled(cron = "0/10 * *  * * ? ")
	public void statByMonth() {
		statMonthProvince();
		statMonthCity();
		statMonthDistrict();
		
	}
	
	
	
	//@Scheduled(cron = "0 0 5 * * 1  ")
	@Scheduled(cron = "0/10 * *  * * ? ")
	public void statByWeek() {
		statWeekProvince();
		statWeekCity();
		statWeekDistrict();
		
	}
	
	
	
	
	private void statMonthProvince(){
		List<BabtAreaCode> areas=carEvlOrderService.queryAllProvince();
		if(CollectionUtils.isEmpty(areas)){
			logger.error("statByMonth query all province ,return null!");
			return;
		}
		
		if(initMonthProvinceFlag == 0)
		{
			for (int i = 0; i < 120; i++) {
				String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(i);
				for(BabtAreaCode area : areas)
				{
					if(area==null)
						continue;
					BabtStGoeMonthProvince result=orderService.queryNMonthAgoByProvince(area.getProvince(), i);
					if(result==null || result.getCarCount()==0){
						continue;
					}
					
					List<BabtStGoeMonthProvince> list  = goeMonthProvinceService.queryByMonthProvince(area.getProvince(), i);
					if(list!=null && !list.isEmpty())
						continue;

					result.setFirstDayOfMonth(firstDateOfnMonthAgo);
					result.insert();
					
				}
			}
			initMonthProvinceFlag = 1;
			return;
		}
		
		String firstDayOfThisMonth=BabtDateUtil.obtainFirstDay0OfthisMonth();
		for (BabtAreaCode area : areas) {
			if(area==null)
				continue;
			BabtStGoeMonthProvince result=orderService.query1MonthAgoByProvince(area.getProvince());
			if(result==null || result.getCarCount()==0){
				continue;
			}

			List<BabtStGoeMonthProvince> list  = goeMonthProvinceService.queryByMonthProvince(area.getProvince(), 0);
			if(list!=null && !list.isEmpty())
				continue;

			result.setFirstDayOfMonth(firstDayOfThisMonth);
			result.insert();
		}
	}
	
	
	private void  statMonthCity(){
		
		List<BabtAreaCode> areas=carEvlOrderService.queryAllCity();
		if(CollectionUtils.isEmpty(areas)){
			logger.error("statByMonth query  allCities ,return null!");
			return;
		}
		
		if(initMonthCityFlag == 0)
		{
			for (int i = 0; i < 120; i++) {
				String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(i);
				for(BabtAreaCode area : areas)
				{
					if(area==null)
						continue;
					BabtStGoeMonthCity result=orderService.queryNMonthAgoByCity(area.getProvince(), area.getCity(), i);
					if(result==null || result.getCarCount()==0){
						continue;
					}
					
					List<BabtStGoeMonthCity> list  = goeMonthCityService.queryByMonthCity(area.getProvince(), area.getCity(), i);
					if(list!=null && !list.isEmpty())
						continue;

					result.setFirstDayOfMonth(firstDateOfnMonthAgo);
					result.insert();
					
				}
			}
			initMonthCityFlag = 1;
			return;
		}
		
		String firstDayOfThisMonth=BabtDateUtil.obtainFirstDay0OfthisMonth();
		for (BabtAreaCode area : areas) {
			if(area==null)
				continue;
			BabtStGoeMonthCity result=orderService.query1MonthAgoByCity(area.getProvince(), area.getCity());
			if(result==null || result.getCarCount()==0){
				continue;
			}
			List<BabtStGoeMonthCity> list = goeMonthCityService.queryByMonthCity(area.getProvince(), area.getCity(), 0);
			if(list!=null && !list.isEmpty())
				continue;
			
			result.setFirstDayOfMonth(firstDayOfThisMonth);
			result.insert();
		}
	}
	
	private void  statMonthDistrict(){
		List<BabtAreaCode> areas=carEvlOrderService.queryAllDistrict();
		if(CollectionUtils.isEmpty(areas)){
			logger.error("statByMonth query  all district ,return null!");
			return;
		}

		if(initMonthDistrictFlag == 0)
		{
			for (int i = 0; i < 120; i++) {
				String firstDateOfnMonthAgo =BabtDateUtil.obtainsFirstDay0OfnMonth(i);
				for(BabtAreaCode area : areas)
				{
					if(area==null)
						continue;
					BabtStGoeMonthDistrict result=orderService.queryNMonthAgoByDistrict(area.getProvince(), area.getCity(), area.getDistrict(), i);
					if(result==null || result.getCarCount()==0){
						continue;
					}
					
					List<BabtStGoeMonthDistrict> list  = goeMonthDistrictService.queryByMonthDistrict(area.getProvince(), area.getCity(), area.getDistrict(), i);
					if(list!=null && !list.isEmpty())
						continue;

					result.setFirstDayOfMonth(firstDateOfnMonthAgo);
					result.insert();
					
				}
			}
			initMonthDistrictFlag = 1;
			return;
		}
		
		String firstDayOfThisMonth=BabtDateUtil.obtainFirstDay0OfthisMonth();
		for (BabtAreaCode area : areas) {
			if(area==null)
				continue;
			BabtStGoeMonthDistrict result=orderService.query1MonthAgoByDistrict(area.getProvince(), area.getCity(), area.getDistrict());
			if(result==null || result.getCarCount()==0){
				continue;
			}
			
			List<BabtStGoeMonthDistrict> list = goeMonthDistrictService.queryByMonthDistrict(area.getProvince(), area.getCity(), area.getDistrict(), 0);
			if(list!=null && !list.isEmpty())
				continue;

			result.setFirstDayOfMonth(firstDayOfThisMonth);
			result.insert();
		}
	}
	
	/////////////////////////////////////////////////
	
	
	private void statWeekProvince(){
		List<BabtAreaCode> areas=carEvlOrderService.queryAllProvince();
		if(CollectionUtils.isEmpty(areas)){
			logger.error("statByMonth query all province ,return null!");
			return;
		}

		if(initWeekProvinceFlag == 0)
		{
			for (int i = 0; i < 520; i++) {
				String nWeekMonday=BabtDateUtil.formateDay(BabtDateUtil.nWeekAgoMonday0Date(i));
				for(BabtAreaCode area : areas)
				{
					if(area==null)
						continue;
					BabtStGoeWeekProvince result=orderService.queryNWeekAgoByProvince(area.getProvince(), i);
					if(result==null || result.getCarCount()==0){
						continue;
					}
					
					List<BabtStGoeWeekProvince> list  = goeWeekProvinceService.queryByWeekProvince(area.getProvince(), i);
					if(list!=null && !list.isEmpty())
						continue;

					result.setMondayDate(nWeekMonday);
					result.insert();
					
				}
			}
			initWeekProvinceFlag = 1;
			return;
		}
		
		String thisMonday=BabtDateUtil.formateDay(BabtDateUtil.getThisWeekMonday());
		for (BabtAreaCode area : areas) {
			if(area==null)
				continue;
			BabtStGoeWeekProvince result=orderService.query1WeekAgoByProvince(area.getProvince());
			if(result==null || result.getCarCount()==0){
				continue;
			}
			
			List<BabtStGoeWeekProvince> list = goeWeekProvinceService.queryByWeekProvince(area.getProvince(), 0);
			if(list!=null && !list.isEmpty())
				continue;

			result.setMondayDate(thisMonday);
			result.insert();
		}
		
		
	}
	
	
	private void  statWeekCity(){
		
		List<BabtAreaCode> areas=carEvlOrderService.queryAllCity();
		if(CollectionUtils.isEmpty(areas)){
			logger.error("statByMonth query  allCities ,return null!");
			return;
		}

		if(initWeekCityFlag == 0)
		{
			for (int i = 0; i < 520; i++) {
				String nWeekMonday=BabtDateUtil.formateDay(BabtDateUtil.nWeekAgoMonday0Date(i));
				for(BabtAreaCode area : areas)
				{
					if(area==null)
						continue;
					BabtStGoeWeekCity result=orderService.queryNWeekAgoByCity(area.getProvince(), area.getCity(), i);
					if(result==null || result.getCarCount()==0){
						continue;
					}
					
					List<BabtStGoeWeekCity> list  = goeWeekCityService.queryByWeekCity(area.getProvince(), area.getCity(), i);
					if(list!=null && !list.isEmpty())
						continue;

					result.setMondayDate(nWeekMonday);
					result.insert();
					
				}
			}
			initWeekCityFlag = 1;
			return;
		}
		
		String thisMonday=BabtDateUtil.formateDay(BabtDateUtil.getThisWeekMonday());
		for (BabtAreaCode area : areas) {
			if(area==null)
				continue;
			BabtStGoeWeekCity result=orderService.query1WeekAgoByCity(area.getProvince(), area.getCity());
			if(result==null || result.getCarCount()==0){
				continue;
			}
			
			List<BabtStGoeWeekCity> list = goeWeekCityService.queryByWeekCity(area.getProvince(), area.getCity(), 0);
			if(list!=null && !list.isEmpty())
				continue;

			result.setMondayDate(thisMonday);
			result.insert();
		}
		
		
	}
	private void  statWeekDistrict(){
		List<BabtAreaCode> areas=carEvlOrderService.queryAllDistrict();
		if(CollectionUtils.isEmpty(areas)){
			logger.error("statWeekDsitrict  query  all district ,return null!");
			return;
		}

		if(initWeekDistrictFlag == 0)
		{
			for (int i = 0; i < 520; i++) {
				String nWeekMonday=BabtDateUtil.formateDay(BabtDateUtil.nWeekAgoMonday0Date(i));
				for(BabtAreaCode area : areas)
				{
					if(area==null)
						continue;
					BabtStGoeWeekDistrict result=orderService.queryNWeekAgoByDistrict(area.getProvince(), area.getCity(), area.getDistrict(), i);
					if(result==null || result.getCarCount()==0){
						continue;
					}
					
					List<BabtStGoeWeekDistrict> list  = goeWeekDistrictService.queryByWeekDistrict(area.getProvince(), area.getCity(), area.getDistrict(), i);
					if(list!=null && !list.isEmpty())
						continue;

					result.setMondayDate(nWeekMonday);
					result.insert();
					
				}
			}
			initWeekDistrictFlag = 1;
			return;
		}
		
		String thisMonday=BabtDateUtil.formateDay(BabtDateUtil.getThisWeekMonday());
		for (BabtAreaCode area : areas) {
			if(area==null)
				continue;
			BabtStGoeWeekDistrict result=orderService.query1WeekAgoByDistrict(area.getProvince(), area.getCity(), area.getDistrict());
			if(result==null || result.getCarCount()==0){
				continue;
			}
			
			List<BabtStGoeWeekDistrict> list = goeWeekDistrictService.queryByWeekDistrict(area.getProvince(), area.getCity(), area.getDistrict(), 0);
			if(list!=null && !list.isEmpty())
				continue;

			result.setMondayDate(thisMonday);
			result.insert();
		}
	}

}
