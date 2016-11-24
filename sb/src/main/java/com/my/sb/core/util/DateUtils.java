/** 
 * 项目名称:91营销云
 * 文件名：DateUtils.java 
 * author:Administrator
 * 版本信息： 
 * 日期：2015-12-14 
 * Copyright 颢云科技 2015 版权所有 
 */

package com.my.sb.core.util;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String SHORT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String ALIGN_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DEFAULT_SQUOTE_DATE_FORMAT = "yyyy/MM/dd";
	public static final String DEFAULT_NOSQUOTE_DATE_FORMAT = "yyyyMMdd";
	
	
	private static final double[] LIMITS = { 0, 1, 2 };

	private static final String[] MINUTES_PART =
		{ "", "1 minute ", "{0,number} minutes " };

	private static final String[] SECONDS_PART =
		{ "0 seconds", "1 second", "{1,number} seconds" };

	private static final ChoiceFormat MINUTES_FORMAT =
		new ChoiceFormat(LIMITS, MINUTES_PART);

	private static final ChoiceFormat SECONDS_FORMAT =
		new ChoiceFormat(LIMITS, SECONDS_PART);

	private static final MessageFormat MINUTE_SECONDS =
		new MessageFormat("{0}{1}");

	static {
		MINUTE_SECONDS.setFormat(0, MINUTES_FORMAT);
		MINUTE_SECONDS.setFormat(1, SECONDS_FORMAT);
	}
	
	public static final long  ONE_SECOND = 1000;
	public static final long  ONE_MINUTE = 60*ONE_SECOND;
	public static final long  ONE_HOUR   = 60*ONE_MINUTE;
	public static final long  ONE_DAY    = 24*ONE_HOUR;
	public static final long  ONE_WEEK   = 7*ONE_DAY;


	public static final SimpleDateFormat _defDateTimeFmt =
		new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);

	public static final SimpleDateFormat _defDateFmt =
		new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	public static String toString(Date date, String format) {

		SimpleDateFormat formatter;

		if ((date == null) || (format == null) || (format.length() == 0)) {
			return null;
		}
		formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static Date toDate(String str, String format) {
		if ((str == null)
			|| (str.length() == 0)
			|| (format == null)
			|| (format.length() == 0)) {
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(str, pos);
	}

	public static boolean compare(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return true;
		}
		if (date1 == null || date2 == null)
			return false;
		else
			return date1.getTime() == date2.getTime();
	}

	public static Date toDate(String str) {
		try {
			if (str.indexOf(':') > 0) {
				return  toDate(str, DEFAULT_DATETIME_FORMAT);
			} else {
				return  toDate(str, DEFAULT_DATE_FORMAT);
			}
		} catch (Exception ex) {
			return null;
		}
	}
	
	

	public static String currentDateToString(String format) {
		Date date = new Date();
		return toString(date, format);
	}
	
	public static String curDateStr() {
		return _defDateFmt.format(new Date());
	}
	
	public static String curDateTimeStr() {
		return _defDateTimeFmt.format(new Date());
	}

	public static String formatElapsedTime(long millis) {
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		Object[] args = { new Long(minutes), new Long(seconds % 60)};
		return MINUTE_SECONDS.format(args);
	}
	
	public static String toDefDateString(Date date) {
		return toString(date, DEFAULT_DATE_FORMAT);
	}
	
	public static String toDefDatetimeString(Date date) {
		return toString(date, DEFAULT_DATETIME_FORMAT);
	}
	
	public static String toDefTimeString(Date date) {
		return toString(date, DEFAULT_TIME_FORMAT);
	}
	public static String convertSecondsToTime(Long seconds){
		long  s;//秒  
  		long  h;//小时  
  		long  m;//分钟  
  		if(0==seconds){
  			return "00:00:00";
  		}
  		seconds = seconds * 1000;
  		h = seconds/1000/60/60;  
  		m=(seconds-h*60*60*1000)/1000/60;  
  		s=seconds/1000-h*60*60-m*60;  
  		return (h<10?("0"+h):h) + ":"+ (m<10?("0"+m):m) + ":" + (s<10?("0"+s):s);
	}
	
	public static Date getTodayStartTime(){
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	public static Date getYearStartTime() {
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DAY_OF_YEAR, 0);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	public static String getSmartDateString(Date date,String formatString){
		SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
		SimpleDateFormat sdf1=new SimpleDateFormat(formatString);
		Long dayLong=24*3600*1000l;
		Long todayStart=DateUtils.getTodayStartTime().getTime();
		Long last=todayStart-date.getTime();
		String time=sdf1.format(date);
		if(last<=0){
			return "今天"+time;
		}else if(last/dayLong>=1){
			return sdf.format(date)+" "+time;
		}else if(last/dayLong==0){
			return "昨天"+time;
		}else{
			return "";
		}
	}
	
	public static String getSmartDateString(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
		Long dayLong=24*3600*1000l;
		Long todayStart=DateUtils.getTodayStartTime().getTime();
		Long last=todayStart-date.getTime();
		if(last<=0){
			Long time=new Date().getTime()-date.getTime();
			int s=(int) (time/1000);
			if(s>=3600){
				return s/3600+"小时前";
			}else if(s>=60){
				return s/60+"分钟前";
			}else{
				return "刚刚";
			}
		}else if(last/dayLong>10){
			return sdf.format(date);
		}else if(last/dayLong>=1){
			return last/dayLong+1+"天前";
		}else if(last/dayLong==0){
			return "昨天";
		}else{
			return "";
		}
	}

	public static int getDays(Date startTime, Date endTime) {
		Long time=endTime.getTime()-startTime.getTime();
		int days=(int) (time/(3600000*24));
		if(endTime.getTime()==toDate(toDefDateString(endTime)).getTime()){
			return days;
		}
		return days+1;
	}

	public static String getSmartLeftTime(Long leftTime) {
		if(leftTime>ONE_DAY){
			return leftTime/ONE_DAY+"天以上";
		}else if(leftTime>=ONE_HOUR){
			return leftTime/ONE_HOUR+"小时以上";
		}else if(leftTime>=ONE_MINUTE){
			return leftTime/ONE_HOUR+1+"分钟";
		}else if(leftTime>0){
			return "一分钟";
		}else{
			return "";
		}
	}
	
	/**
	 * 距离目标日期相应天数的日期
	 * 
	 * @param date
	 *            目标日期
	 * @param to
	 *            距离天数
	 * @return
	 */
	public static String getDateToToday(String date, int to) {
		String str = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date myDate = formatter.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(myDate);
			c.add(Calendar.DATE, to);
			myDate = c.getTime();
			str = formatter.format(myDate);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return str;
	}
}


