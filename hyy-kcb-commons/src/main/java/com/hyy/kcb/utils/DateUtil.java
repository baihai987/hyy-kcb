package com.hyy.kcb.utils;

import java.sql.Timestamp;
import java.text.*;
import java.util.*;

/**
 * 日期处理工具类
 * 
 * @author crj
 */
public final class DateUtil {
	/** yyyy-MM-dd */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	/** yyyyMMdd */
	public static final String DATE_FORMAT = "yyyyMMdd";
	/** HH:mm:ss */
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	/** yyyy-MM-dd HH:mm:ss */
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	/** yyyy年MM月dd日 */
	public static final String CN_DATE_FORMAT = "yyyy年MM月dd日";

	/**
	 * 此类不需要实例化
	 */
	private DateUtil() {
	}

	private static Date date = null;
	private static DateFormat dateFormat = null;
	private static Calendar calendar = null;

	/**
	 * 时间转换：长整型转换为日期字符型
	 * 
	 * @param format
	 *            格式化类型：yyyy-MM-dd
	 * @param time
	 *            13位有效数字：1380123456789
	 * 
	 * @return 格式化结果 (yyyy-MM-dd)
	 */
	//格式化夜间维护时间晚上24点到早上7点

	public static String formatToString(String format, long time) {
		if (time == 0) {
			return "";
		}
		return new SimpleDateFormat(format).format(new Date(time));
	}
	public static  boolean formatNightMaintainTime(){
		try {
			Date startTime = new SimpleDateFormat(DEFAULT_TIME_FORMAT).parse("00:00:00");
			Date endTime = new SimpleDateFormat(DEFAULT_TIME_FORMAT).parse("07:00:00");
			Date nowTime = new Date();
			if (nowTime.getTime() == startTime.getTime()|| nowTime.getTime() == endTime.getTime()) {
				return true;
			}
			Calendar date = Calendar.getInstance();
			date.setTime(nowTime);
			Calendar begin = Calendar.getInstance();
			begin.setTime(startTime);
			Calendar end = Calendar.getInstance();
			end.setTime(endTime);
			return !date.after(begin) || !date.before(end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * 时间转换：日期字符型转换为长整型
	 * 
	 * @param format
	 *            格式化类型：yyyy-MM-dd
	 * 
	 * @return 13位有效数字 (1380123456789)
	 */
	public static long formatToLong(String format) {
		SimpleDateFormat f = new SimpleDateFormat(format);
		return Timestamp.valueOf(f.format(new Date())).getTime();
	}

	/**
	 * 获取当前年份
	 * 
	 * @return yyyy (2016)
	 */
	public static int getYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 获取当前月份
	 * 
	 * @return MM (06)
	 */
	public static String getMonth() {
		Calendar cal = Calendar.getInstance();
		return new DecimalFormat("00").format(cal.get(Calendar.MONTH));
	}
	/**
	 * 获取当前日期
	 * 
	 * @return MM (06)
	 */
	public static String getDay() {
		Calendar cal = Calendar.getInstance();
		return new DecimalFormat("00").format(cal.get(Calendar.DAY_OF_MONTH));
	}

    /**
     *
     * @param dateType 时间类型 只能是day week month quarter semiAnnual annual
     * @return 一个开始时间，结束时间
     */
	public static Map<String,String> getVariableDate(String dateType){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        HashMap<String, String> map = new HashMap<String, String>();
        if(dateType.trim().equals("annual")){
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.DAY_OF_YEAR,cal.getActualMinimum(Calendar.DAY_OF_YEAR));
            String startTime = sdf.format(cal.getTime());
            cal.set(Calendar.DAY_OF_YEAR,cal.getActualMaximum(Calendar.DAY_OF_YEAR));
            String endTime = sdf.format(cal.getTime());
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            return dateFormat(map);
        } else if
		(dateType.trim().equals("week")){
            Calendar cal = Calendar.getInstance();

			cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
            int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
            if(dayWeek==1){
                dayWeek = 8;
            }

            cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - dayWeek);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
            Date mondayDate = cal.getTime();
            String weekBegin = sdf.format(mondayDate);
            cal.add(Calendar.DATE, 4 +cal.getFirstDayOfWeek());
            Date sundayDate = cal.getTime();
            String weekEnd = sdf.format(sundayDate);
            map.put("startTime", weekBegin);
            map.put("endTime", weekEnd);
            return dateFormat(map);
        }else if
        (dateType.trim().equals("month")){
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            String startTime = sdf.format(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            String endTime = sdf.format(calendar.getTime());
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            return dateFormat(map);
        }else if
        (dateType.trim().equals("quarter")){
            Calendar cal = Calendar.getInstance();
            int currentMonth = cal.get(Calendar.MONTH) + 1;
            //第一季度
            if(currentMonth >= 1 && currentMonth <= 3){
                cal.set(Calendar.MONTH, 0);
                cal.set(Calendar.DATE,1);
                String startTime = sdf.format(cal.getTime());
                cal.set(Calendar.MONTH,2);
                cal.set(Calendar.DATE, 31);
                String endTime = sdf.format(cal.getTime());
                map.put("startTime",startTime);
                map.put("endTime",endTime);
                return dateFormat(map);
            //第二季度
            }else if (currentMonth >= 4 && currentMonth <= 6){
                cal.set(Calendar.MONTH, 3);
                cal.set(Calendar.DATE,1);
                String startTime = sdf.format(cal.getTime());
                cal.set(Calendar.MONTH,5);
                cal.set(Calendar.DATE,30);
                String endTime = sdf.format(cal.getTime());
                map.put("startTime",startTime);
                map.put("endTime",endTime);
                return dateFormat(map);

            //第三季度
            }else if(currentMonth >= 7 && currentMonth <= 9){
                cal.set(Calendar.MONTH, 6);
                cal.set(Calendar.DATE,1);
                String startTime = sdf.format(cal.getTime());
                cal.set(Calendar.MONTH,8);
                cal.set(Calendar.DATE,30);
                String endTime = sdf.format(cal.getTime());
                map.put("startTime",startTime);
                map.put("endTime",endTime);
                return dateFormat(map);

            //第四季度
            }
                cal.set(Calendar.MONTH, 9);
                cal.set(Calendar.DATE,1);
                String startTime = sdf.format(cal.getTime());
                cal.set(Calendar.MONTH,11);
                cal.set(Calendar.DATE, 31);
                String endTime = sdf.format(cal.getTime());
                map.put("startTime",startTime);
                map.put("endTime",endTime);
                return dateFormat(map);

        }else if
        (dateType.trim().equals("semiAnnual")){
            Calendar cal = Calendar.getInstance();
            int currentMonth = cal.get(Calendar.MONTH) + 1;
            //上半年
            if(1<=currentMonth&&currentMonth<=6){
                cal.set(Calendar.MONTH, 0);
                cal.set(Calendar.DATE,1);
                String startTime = sdf.format(cal.getTime());
                cal.set(Calendar.MONTH, 5);
                cal.set(Calendar.DATE,30);
                String endTime = sdf.format(cal.getTime());
                map.put("startTime",startTime);
                map.put("endTime",endTime);
                return dateFormat(map);
            }
            //下半年
            cal.set(Calendar.MONTH, 6);
            cal.set(Calendar.DATE,1);
            String startTime = sdf.format(cal.getTime());
            cal.set(Calendar.MONTH, 11);
            cal.set(Calendar.DATE,31);
            String endTime = sdf.format(cal.getTime());
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            return dateFormat(map);
        }
        //默认查询当天
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);

		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		//开始时间
        String startTime = sdf.format(todayStart.getTime());
		String endTime = sdf.format(todayEnd.getTime());
        map.put("startTime",startTime);
        map.put("endTime", endTime);

		return dateFormat(map);
    }

	/**
	 * 重新赋值给map
	 */
	private static Map<String,String> dateFormat(Map<String,String> map){
		String startTime = map.get("startTime");
		String endTime = map.get("endTime");
		startTime += " 00:00:00:000";
		endTime += " 23:59:59:999";
		map.put("startTime",startTime);
		map.put("endTime",endTime);
		return map;
	}
	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		if(StringUtils.isEmpty(format)) {
			format = "yyyy-MM-dd mm:dd:ss";
		}
		if(!dateStr.contains(":")) {
			dateStr = dateStr + " 00:00:00";
		}
		try {
			dateFormat = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("/", "-");
			dt = dateStr;
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]", "0");
			}
			date = (Date) dateFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, DEFAULT_DATE_TIME_FORMAT);
	}
	
	public static Date parseDate2(String dateStr) {
		dateStr = dateStr +":"+ getSecond(new Date());
		return parseDate(dateStr, DEFAULT_DATE_TIME_FORMAT);
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date prrseStringDate(String dateStr) {
		return parseDate(dateStr, DEFAULT_DATE_TIME_FORMAT);
	}
	
	
	
	/**
	   * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
	   * 
	   * @param strDate
	   * @return
	   */
	public static Date strToDateLong(String strDate) {
	   SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
	   ParsePosition pos = new ParsePosition(0);
	   Date strtodate = formatter.parse(strDate, pos);
	   return strtodate;
	}
	
	/**
	 * 功能描述：格式化输出日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 功能描述：
	 * 
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String format(Date date) {
		return format(date, DEFAULT_DATE_TIME_FORMAT);
	}
	/**
	 * @Description: 获取当前时间
	 * @date 2017年4月6日 上午10:13:02 
	 * @version V1.0 
	 * @return
	 */
	public static String getyyyyMMddHHmmssDate() {
		return format(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		calendar = Calendar.getInstance();
//		calendar.clear();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 功能描述：返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy-MM-dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 功能描述：返回字符型时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy-MM-dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	public static Integer getAge(String birthDate){
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy").format(date);
        return  (Integer.valueOf(format)-Integer.valueOf(birthDate));
    }
	public static List<String> getFormatDate(String dateFormat, int days){
        ArrayList<String> objects = new ArrayList<String>();
	    //获取当前的时间
        Date date = new Date();
        for(int i =1;i<=days;i++){
            //前i天的时间
            long lastDay = getMillis(date) - ((long) i) * 24 * 3600 * 1000;
            //往前推算需要的时间天数，将每天的日期加入到list中
            String format = new SimpleDateFormat(dateFormat).format(lastDay);
            objects.add(format);
        }



        return objects;
    }
	/**
	 *增加分钟
	 * @param date
	 * @param minutes
	 * @return
	 */
	public static Date addMinutes(Date date, int minutes)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(12, minutes);
		return c.getTime();
	}
	/**
	 *增加秒
	 * @param date
	 * @param second
	 * @return
	 */
	public static Date addSecond(Date date, int second)
	  {
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  c.add(Calendar.SECOND, second);
		  return c.getTime();
	  }

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 * @throws ParseException
	 */
	public static String add(String date, int day) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		long d = df.parse(date).getTime();
		long millis = d + ((long) day) * 24 * 3600 * 1000;
		return df.format(new Date(millis));
	}
	
	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 * @throws ParseException
	 */
	public static Date diff(Date date, int day) throws ParseException {
		long d = date.getTime();
		long millis = d - ((long) day) * 24 * 3600 * 1000;
		return new Date(millis);
	}

	/**
	 * 功能描述：日期相减
	 * 
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}
	
	/**
	 * 两个时间相减，得到结果  ，如果满足24倍数，返回相差天数
	 * 不满足24倍数，按照一天计算
	 */
	public static int diffDateToDay(Date date_min, Date date_max) {
		int diffDate = diffDate(date_max, date_min);
		if(diffDate > 0) { //按照时分秒计算，累计时间超过一天
			return diffDate + 1;
		} else { //累计时间不够一天
			return 1;
		}
	}
	
	/**
	 * 两个时间相减，得到结果  ，如果满足24倍数，返回相差天数
	 * 不满足24倍数，按照一天计算
	 * @return
	 */
	public static int diffDateToDay_test(Date date_min, Date date_max) {
		System.out.println(getMillis(date_min));
		System.out.println(getMillis(date_max));
		System.out.println(getMillis(date_max) - getMillis(date_min));
		long diff=(getMillis(date_max)-getMillis(date_min))/1000/60;
		System.out.println("当前系统时间为："+format(date_max)+"下单时间为："+format(date_min)+"两个时间差为："+diff+"分钟");
		
		if(diff <= 30) {
			return 1;
		} else {
			if(diff % 30 ==0) {
				return Integer.valueOf(String.valueOf(diff / 30));
			} else {
				return Integer.valueOf(String.valueOf(diff / 30)) + 1;
			}
		}
	}
	
	/**
	 * 功能描述：取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		date = parseDate(getMonthBegin(strdate));
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 功能描述：常用的格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 计算日期之间的天数
	 * 
	 * @param beginDate
	 *            开始日期 yyy-MM-dd
	 * @param endDate
	 *            结束日期 yyy-MM-dd
	 * @return
	 * @throws ParseException
	 */
	public static int getDay(String beginDate, String endDate) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		long to = df.parse(endDate).getTime();
		long from = df.parse(beginDate).getTime();
		return (int) ((to - from) / (1000 * 60 * 60 * 24));
	}
	
	/**
	 * 当前时间 加上 多少天时间  得到一个新的时间
	 */
	public static Date getNewDate(int day) {
		GregorianCalendar now = new GregorianCalendar();
		now.add(GregorianCalendar.DATE,+day);
		return now.getTime();
	}
	
	public static Date getOldDate(int day) {
		GregorianCalendar now = new GregorianCalendar();
		now.add(GregorianCalendar.DATE,-day);
		return now.getTime();
	}

	public static int countDays(Date createDate) {
		long to = new Date().getTime();
		long from = createDate.getTime();
		return (int) ((to - from) / (1000 * 60 * 60 * 24));
	}
	
	public static long getToDay(Date begin_date, Date end_date) {
		  long day = 0;
		  try {
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		   String sdate = format.format(Calendar.getInstance().getTime());
		   
		   if (begin_date == null) {
		    begin_date = format.parse(sdate);
		   }
		   if (end_date == null) {
		    end_date = format.parse(sdate);
		   }
		   day = (end_date.getTime() - begin_date.getTime())
		     / (24 * 60 * 60 * 1000);
		  } catch (Exception e) {
		   return -1;
		  }
		  return day;
	 }
	
	public static String getDateOrder(){
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmm");
	  	String sdate = format.format(Calendar.getInstance().getTime());
	    return sdate;
	}
	
	/**
	 * 获取当前月的下一个月的第一天
	 * @param year  2017
	 * @param month 12
	 * @return 2018-01-01
	 * @throws ParseException 
	 */
	public static Date getFirstDayOfMonth(int year,int month) throws ParseException {
	    Calendar cal = Calendar.getInstance();
	    //设置年份
	    cal.set(Calendar.YEAR,year);
	    //设置月份
	    cal.set(Calendar.MONTH, month);
	    //设置日历中月份的第1天
	    cal.set(Calendar.DAY_OF_MONTH, 1);
	    //格式化日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String firstDayOfMonth = sdf.format(cal.getTime());
	    
	    return sdf.parse(firstDayOfMonth) ;
	  }
	
	public static void format_test(Long ms) {
		System.out.println("当前毫秒:ms="+ms);
	}
	
    /*
     * 毫秒天数
     */
    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;
 
        Long day = ms / dd;  //当前秒
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
        
        StringBuffer sb = new StringBuffer();
        if(day > 0) {
            sb.append(day+"天");
        }
        if(hour > 0) {
            sb.append(hour+"小时");
        }
        if(minute > 0) {
            sb.append(minute+"分");
        }
        if(second > 0) {
            sb.append(second+"秒");
        }
        if(milliSecond > 0) {
            sb.append(milliSecond+"毫秒");
        }
        System.out.println(minute + hour * 60);
        return sb.toString();
    }
	
	public static void main(String[] args) throws Exception{
		
		SimpleDateFormat sdf_job = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date job_date = sdf_job.parse("2019-06-04 01:59:00");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date order_date = sdf.parse("2019-06-04 00:04:00");
		int day = diffDateToDay_test(order_date, job_date);
//		String day = formatDuring(order_date, new Date());
//		String day = formatTime(Long.valueOf(new Date().getTime() - order_date.getTime()));
		System.out.println(day);
	    
	}
}
