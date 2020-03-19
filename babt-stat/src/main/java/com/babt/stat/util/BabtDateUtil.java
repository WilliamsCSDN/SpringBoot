package com.babt.stat.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BabtDateUtil {
	
	
	
	//一年前的月份的第一天
	public static Date firstDayOfoneYearAgo(){
		Calendar cal = Calendar.getInstance();  
		cal.add(Calendar.MONTH, -12);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
		return cal.getTime();
		
	}
	
	//5年+2个月之前当月第一天0点
	public static Date firstDayOf5year2MonthAgo(){
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.YEAR, -5);
		cal.add(Calendar.MONTH, -2);
        cal.set(Calendar.DAY_OF_MONTH, 1);  
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
		return cal.getTime();
	}
	
	
    public static Date getThisWeekMonday() {  
        Calendar cal = Calendar.getInstance();  
        // 获得当前日期是一个星期的第几天  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);  
        if (1 == dayWeek) {  
            cal.add(Calendar.DAY_OF_MONTH, -1);  
        }  
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);  
        // 获得当前日期是一个星期的第几天  
        int day = cal.get(Calendar.DAY_OF_WEEK);  
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值  
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);  
        cal.set(Calendar.HOUR_OF_DAY,0);
        cal.set(Calendar.MINUTE,0);
        cal.set(Calendar.SECOND,0);
        return cal.getTime();
    }  
	
	
	// 获取n周前的周一的日期
	public static String nWeekAgoMonday0(int n){
		Calendar calendar = Calendar.getInstance();
		// 获取这周一
		calendar.setTime(getThisWeekMonday());
		// 日期- n*7
		calendar.add(Calendar.DATE, -Calendar.DAY_OF_WEEK*n);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		return formateDay(calendar.getTime());
	}
	
	public static Date nWeekAgoMonday0Date(int n){
		Calendar calendar = Calendar.getInstance();
		// 获取这周一
		calendar.setTime(getThisWeekMonday());
		// 日期- n*7
		calendar.add(Calendar.DATE, -Calendar.DAY_OF_WEEK*n);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		return calendar.getTime();
	}

	public static Date nWeekAgoMonday24Date(int n){
		Calendar calendar = Calendar.getInstance();
		// 获取这周一
		calendar.setTime(getThisWeekMonday());
		// 日期- n*7
		calendar.add(Calendar.DATE, -Calendar.DAY_OF_WEEK*(n-1)-1);
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		
		return calendar.getTime();
	}
	
	
	
	// 前一周的周一0时
	public static Date oneWeekAgoMonday0(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getThisWeekMonday());
		calendar.add(Calendar.DATE, -Calendar.DAY_OF_WEEK);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		
		return calendar.getTime();
	}
	
	// 前一周的周日23:59:59
	public static Date oneWeekAgoSunDay24(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oneWeekAgoMonday0());
		// +6  取24点
		calendar.add(Calendar.DATE, Calendar.DAY_OF_WEEK-1);
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
		
		return calendar.getTime();
	}
	
	public static String formateHHmmss(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static String formateDay(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String getYearOfNow(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}

	
	
	public static Date obtainFirstDay0OfnMonth(int n){
		Calendar  calendar = Calendar.getInstance();  
		calendar.add(Calendar.MONTH, 0);  
		// 设置为当月第一天
		calendar.set(Calendar.DAY_OF_MONTH, 1); 
		
		calendar.add(Calendar.MONTH,-n);
		
		//时分秒清0
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return calendar.getTime();
	}
	
	public static String obtainsFirstDay0OfnMonth(int n){
		return formateDay(obtainFirstDay0OfnMonth(n));
	}
	
	public static Date obtainLastDay24OfnMonth(int n){
		
        // 获取前月的第一天  
		Calendar  calendar = Calendar.getInstance();  
		calendar.add(Calendar.MONTH, 0);  
		calendar.set(Calendar.DAY_OF_MONTH, 1);  
        
        
        // 获取前月的最后一天  
		calendar = Calendar.getInstance(); 
		//设置月份
		calendar.add(Calendar.MONTH,-n);
        // 加一个月
		calendar.add(Calendar.MONTH, 1);  
		calendar.set(Calendar.DAY_OF_MONTH, 0);  
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE,59);
		calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
	}
	
	
	public static String obtainsLastDay24OfnMonth(int n){
        return formateDay(obtainLastDay24OfnMonth(n));
	}
	
	public static String obtainFirstDay0OfthisMonth(){
		Calendar  calendar = Calendar.getInstance();  
		calendar.add(Calendar.MONTH, 0);  
		// 设置为当月第一天
		calendar.set(Calendar.DAY_OF_MONTH, 1); 
		//时分秒清0
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		return formateDay(calendar.getTime());
	}
	
	public static int obtainNthMonth(){
		Date now =new Date();
		return Integer.parseInt(formateDay(now).split("-")[1]);
	}
	
	public static void main(String[] args) {
		
//		System.out.println(oneWeekAgoMonday0());
//		System.out.println(oneWeekAgoSunDay24());
//		System.out.println(nWeekAgoMonday0(1));
//		System.out.println(firstDayOf5year2MonthAgo());
//		
//		System.out.println(formateDay(getThisWeekMonday()));
		
//		for (int i = 0; i < 12; i++) {
//			System.out.println(obtainFirstDay0OfnMonth(i));
//			System.out.println(obtainLastDay24OfnMonth(i));
//			
//		}
		
	}
}
