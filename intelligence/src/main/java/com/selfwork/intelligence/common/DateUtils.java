package com.selfwork.intelligence.common;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间工具类
 *
 * @author zzc
 */
public class DateUtils {
    public final static int TIME_DAY_MILLISECOND = 86400000;

    private final static String DATE_FORMAT = "yyyy-MM-dd";

    private final static String DATE_FORMAT_POINT = "yyyy.MM.dd";

    private final static String DATE_FORMAT_CN = "yyyy年MM月dd日";

    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final static String TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";

    public final static String MONTH_FORMAT = "yyyy-MM";

    private final static String DAY_FORMAT = "yyyyMMdd";


    /**
     * 获取时间差 分钟
     **/
    public static int getMinutesTimeSpan(Date start, Date end) {

        try {
            SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT);//设置日期格式
            String fromDate = df.format(start);
            String toDate = df.format(end);
            long from = df.parse(fromDate).getTime();
            long to = df.parse(toDate).getTime();
            int minutes = (int) ((to - from) / (1000 * 60));

            return minutes;
        } catch (ParseException e) {
            return 0;
        }

    }

    /**
     * 获取时间差 秒数
     **/
    public static long getSecondsTimeSpan(Date start, Date end) {
        try {

            return (end.getTime() - start.getTime()) / 1000;

        } catch (Exception e) {

            return 0;
        }
    }

    /*
  * 将时间戳转换为时间
  */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static String formatUtcDate(Date date) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        synchronized (simpleDateFormat) {
            return simpleDateFormat.format(date);
        }
    }

    /***
     * 获取日期为周几
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String week = sdf.format(date);
        return week;
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDateForString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }


    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd
     */
    public static String getNowDateForshort() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    /**
     * 取得当前系统时间，返回java.util.Date类型
     *
     * @return java.util.Date 返回服务器当前系统时间
     * @see Date
     */
    public static Date getCurrDate() {
        return new Date();
    }

    /**
     * 取得当前系统时间戳
     *
     * @return java.sql.Timestamp 系统时间戳
     * @see java.sql.Timestamp
     */
    public static java.sql.Timestamp getCurrTimestamp() {
        return new java.sql.Timestamp(System.currentTimeMillis());
    }

    /**
     * 将2007-12-1变成2007-12-01。将2007-9-1变为2007-09-01。
     *
     * @param date
     * @return
     */
    public static String getFormatDateV2(String date) {
        if (date == null) {
            return null;
        }

        String[] datearr = StringUtils.split(date, "-");
        if (datearr == null || datearr.length != 3) {
            return date;
        }

        StringBuffer ret = new StringBuffer();
        ret.append(datearr[0]);
        ret.append("-");
        ret.append(
                Integer.parseInt(datearr[1]) < 10 ? "0" + Integer.parseInt(datearr[1]) : datearr[1]);
        ret.append("-");
        ret.append(
                Integer.parseInt(datearr[2]) < 10 ? "0" + Integer.parseInt(datearr[2]) : datearr[2]);
        return ret.toString();
    }

    /**
     * 从时间串中获取小时数。
     *
     * @param timestr "2007-10-12 13:25:00"
     * @return
     */
    public static int getHourFromTimeString(String timestr) {
        if (StringUtils.isEmpty(timestr)) {
            return 0;
        }

        return Integer.parseInt(timestr.substring(timestr.length() - 8, timestr.length() - 6));
    }

    /**
     * 返回当前时间是上午还是下午
     * <p>
     * Calendar.AM 0
     * Calendar.PM 1
     *
     * @return
     * @author lenghao
     * @createTime 2008-8-2 下午04:22:07
     */
    public static Integer getCurrDateAMorPM() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.AM_PM);
    }


    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
     *
     * @param currDate 要格式化的日期
     * @return String 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2006-02-15
     * @see #getFormatDate(Date, String)
     */
    public static String getFormatDate(Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }

    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
     *
     * @param currDate 要格式化的日期
     * @return Date 返回格式化后的日期，默认格式为为yyyy-MM-dd，如2006-02-15
     * @see #getFormatDate(Date)
     */
    public static Date getFormatDateToDate(Date currDate) {
        return getFormatDate(getFormatDate(currDate));
    }

    /**
     * 得到格式化后的日期，格式为yyyy年MM月dd日，如2006年02月15日
     *
     * @param currDate 要格式化的日期
     * @return String 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2006年02月15日
     * @see #getFormatDate(Date, String)
     */
    public static String getFormatDate_CN(Date currDate) {
        return getFormatDate(currDate, DATE_FORMAT_CN);
    }

    /**
     * 得到格式化后的日期，格式为yyyy年MM月dd日，如2006年02月15日
     *
     * @param currDate 要格式化的日期
     * @return Date 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2006年02月15日
     * @see #getFormatDate_CN(String)
     */
    public static Date getFormatDateToDate_CN(Date currDate) {
        return getFormatDate_CN(getFormatDate_CN(currDate));
    }

    /**
     * 得到格式化后的日期，格式为yyyy-MM-dd，如2006-02-15
     *
     * @param currDate 要格式化的日期
     * @return Date 返回格式化后的日期，默认格式为yyyy-MM-dd，如2006-02-15
     * @see #getFormatDate(String, String)
     */
    public static Date getFormatDate(String currDate) {
        return getFormatDate(currDate, DATE_FORMAT);
    }

    /**
     * 得到格式化后的日期，格式为yyyy年MM月dd日，如2006年02月15日
     *
     * @param currDate 要格式化的日期
     * @return 返回格式化后的日期，默认格式为yyyy年MM月dd日，如2006年02月15日
     * @see #getFormatDate(String, String)
     */
    public static Date getFormatDate_CN(String currDate) {
        return getFormatDate(currDate, DATE_FORMAT_CN);
    }

    /**
     * 根据格式得到格式化后的日期
     *
     * @param currDate 要格式化的日期
     * @param format   日期格式，如yyyy-MM-dd
     * @return String 返回格式化后的日期，格式由参数<code>format</code>
     * 定义，如yyyy-MM-dd，如2006-02-15
     * @see SimpleDateFormat#format(Date)
     */
    public static String getFormatDate(Date currDate, String format) {
        if (currDate == null) {
            return "";
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            try {
                return dtFormatdB.format(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
     *
     * @param currDate 要格式化的时间
     * @return String 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2006-02-15
     * 15:23:45
     * @see #getFormatDateTime(Date, String)
     */
    public static String getFormatDateTime(Date currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT);
    }

    /**
     * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
     *
     * @param currDate 要格式环的时间
     * @return Date 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
     * @see #getFormatDateTime(String)
     */
    public static Date getFormatDateTimeToTime(Date currDate) {
        return getFormatDateTime(getFormatDateTime(currDate));
    }

    /**
     * 得到格式化后的时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
     *
     * @param currDate 要格式化的时间
     * @return Date 返回格式化后的时间，默认格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
     * @see #getFormatDateTime(String, String)
     */
    public static Date getFormatDateTime(String currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT);
    }

    /**
     * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
     *
     * @param currDate 要格式化的时间
     * @return String 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日
     * 15:23:45
     * @see #getFormatDateTime(Date, String)
     */
    public static String getFormatDateTime_CN(Date currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT_CN);
    }

    /**
     * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
     *
     * @param currDate 要格式化的时间
     * @return Date 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日
     * 15:23:45
     * @see #getFormatDateTime_CN(String)
     */
    public static Date getFormatDateTimeToTime_CN(Date currDate) {
        return getFormatDateTime_CN(getFormatDateTime_CN(currDate));
    }

    /**
     * 得到格式化后的时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
     *
     * @param currDate 要格式化的时间
     * @return Date 返回格式化后的时间，默认格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日
     * 15:23:45
     * @see #getFormatDateTime(String, String)
     */
    public static Date getFormatDateTime_CN(String currDate) {
        return getFormatDateTime(currDate, TIME_FORMAT_CN);
    }

    /**
     * 根据格式得到格式化后的时间
     *
     * @param currDate 要格式化的时间
     * @param format   时间格式，如yyyy-MM-dd HH:mm:ss
     * @return String 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd
     * HH:mm:ss
     * @see SimpleDateFormat#format(Date)
     */
    public static String getFormatDateTime(Date currDate, String format) {
        if (currDate == null) {
            return "";
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.format(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            try {
                return dtFormatdB.format(currDate);
            } catch (Exception ex) {
            }
        }
        return "";
    }

    /**
     * 根据格式得到格式化后的日期
     *
     * @param currDate 要格式化的日期
     * @param format   日期格式，如yyyy-MM-dd
     * @return Date 返回格式化后的日期，格式由参数<code>format</code>
     * 定义，如yyyy-MM-dd，如2006-02-15
     * @see SimpleDateFormat#parse(String)
     */
    public static Date getFormatDate(String currDate, String format) {
        if (currDate == null) {
            return null;
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(DATE_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 根据格式得到格式化后的时间
     *
     * @param currDate 要格式化的时间
     * @param format   时间格式，如yyyy-MM-dd HH:mm:ss
     * @return Date 返回格式化后的时间，格式由参数<code>format</code>定义，如yyyy-MM-dd
     * HH:mm:ss
     * @see SimpleDateFormat#parse(String)
     */
    public static Date getFormatDateTime(String currDate, String format) {
        if (currDate == null) {
            return null;
        }
        SimpleDateFormat dtFormatdB = null;
        try {
            dtFormatdB = new SimpleDateFormat(format);
            return dtFormatdB.parse(currDate);
        } catch (Exception e) {
            dtFormatdB = new SimpleDateFormat(TIME_FORMAT);
            try {
                return dtFormatdB.parse(currDate);
            } catch (Exception ex) {
            }
        }
        return null;
    }

    /**
     * 得到本日的上月时间 如果当日为2007-9-1,那么获得2007-8-1
     */
    public static String getDateBeforeMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到本日的前几个月时间 如果number=2当日为2007-9-1,那么获得2007-7-1
     */
    public static String getDateBeforeMonth(int number) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -number);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    public static long getDaysOfDates(Date first, Date second) {
        Date d1 = getFormatDateTime(getFormatDate(first), DATE_FORMAT);
        Date d2 = getFormatDateTime(getFormatDate(second), DATE_FORMAT);

        long mils = d1.getTime() - d2.getTime();

        return mils / (TIME_DAY_MILLISECOND);
    }


    /**
     * 获得两个Date型日期之间相差的天数（第2个减第1个）
     *
     * @param first first, Date second
     * @return int 相差的天数 传入为空返回-1
     */
    public static int getDaysBetweenDates(Date first, Date second) {
        if (first == null || second == null) {
            return -1;
        }
        Date d1 = getFormatDateTime(getFormatDate(first), DATE_FORMAT);
        Date d2 = getFormatDateTime(getFormatDate(second), DATE_FORMAT);
        if (d1 == null || d2 == null) {
            return -1;
        }
        Long mils = (d2.getTime() - d1.getTime()) / (TIME_DAY_MILLISECOND);

        return mils.intValue();
    }

    /**
     * 获得两个String型日期之间相差的天数（第2个减第1个）
     *
     * @param first, String second
     * @return int 相差的天数
     */
    public static int getDaysBetweenDates(String first, String second) {
        if (StringUtils.isEmpty(first) || StringUtils.isEmpty(second)) {
            return -1;
        }
        Date d1 = getFormatDateTime(first, DATE_FORMAT);
        Date d2 = getFormatDateTime(second, DATE_FORMAT);
        if (d1 == null || d2 == null) {
            return -1;
        }
        Long mils = (d2.getTime() - d1.getTime()) / (TIME_DAY_MILLISECOND);

        return mils.intValue();
    }

    /**
     * @param first
     * @param second
     * @return 获取两个Date之间的天数的列表
     * @author lenghao
     * @createTime 2008-8-5 下午01:57:09
     */
    public static List<Date> getDaysListBetweenDates(Date first, Date second) {
        List<Date> dateList = new ArrayList<Date>();
        Date d1 = getFormatDateTime(getFormatDate(first), DATE_FORMAT);
        Date d2 = getFormatDateTime(getFormatDate(second), DATE_FORMAT);
        if (d1.compareTo(d2) > 0) {
            return dateList;
        }
        do {
            dateList.add(d1);
            d1 = getDateBeforeOrAfter(d1, 1);
        } while (d1.compareTo(d2) <= 0);
        return dateList;
    }

    /**
     * 得到格式化后的当前系统日期，格式为yyyy-MM-dd，如2006-02-15
     *
     * @return String 返回格式化后的当前服务器系统日期，格式为yyyy-MM-dd，如2006-02-15
     * @see #getFormatDate(Date)
     */
    public static String getCurrDateStr() {
        return getFormatDate(getCurrDate());
    }

    /**
     * 得到格式化后的当前系统时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15 15:23:45
     *
     * @return String 返回格式化后的当前服务器系统时间，格式为yyyy-MM-dd HH:mm:ss，如2006-02-15
     * 15:23:45
     * @see #getFormatDateTime(Date)
     */
    public static String getCurrDateTimeStr() {
        return getFormatDateTime(getCurrDate());
    }

    /**
     * 得到格式化后的当前系统日期，格式为yyyy年MM月dd日，如2006年02月15日
     *
     * @return String 返回当前服务器系统日期，格式为yyyy年MM月dd日，如2006年02月15日
     * @see #getFormatDate(Date, String)
     */
    public static String getCurrDateStr_CN() {
        return getFormatDate(getCurrDate(), DATE_FORMAT_CN);
    }

    /**
     * 得到格式化后的当前系统时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日 15:23:45
     *
     * @return String 返回格式化后的当前服务器系统时间，格式为yyyy年MM月dd日 HH:mm:ss，如2006年02月15日
     * 15:23:45
     * @see #getFormatDateTime(Date, String)
     */
    public static String getCurrDateTimeStr_CN() {
        return getFormatDateTime(getCurrDate(), TIME_FORMAT_CN);
    }

    /**
     * 得到系统当前日期的前或者后几天
     *
     * @param iDate 如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @return Date 返回系统当前日期的前或者后几天
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfter(int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }


    /**
     * 得到日期的前或者后几天
     *
     * @param iDate 如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几天
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }

    /**
     * 得到格式化后的月份，格式为yyyy-MM，如2006-02
     *
     * @param currDate 要格式化的日期
     * @return String 返回格式化后的月份，格式为yyyy-MM，如2006-02
     * @see #getFormatDate(Date, String)
     */
    public static String getFormatMonth(Date currDate) {
        return getFormatDate(currDate, MONTH_FORMAT);
    }

    /**
     * 得到格式化后的日，格式为yyyyMMdd，如20060210
     *
     * @param currDate 要格式化的日期
     * @return String 返回格式化后的日，格式为yyyyMMdd，如20060210
     * @see #getFormatDate(Date, String)
     */
    public static String getFormatDay(Date currDate) {
        return getFormatDate(currDate, DAY_FORMAT);
    }

    /**
     * 得到格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
     *
     * @param
     * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     */
    public static String getFirstDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /***
     * 获取时间的23点59分59秒
     * @param currDate
     * @return
     */
    public static Date getToDay23(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
        return cal.getTime();
    }

    /**
     * 获取日期的周一时间
     */
    public static Date getMonday(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.add(Calendar.DAY_OF_MONTH, -1); //解决周日会出现 并到下一周的情况
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获取日期的周末时间
     */
    public static Date getSunday(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY); //将每周第一天设为周一
        cal.set(Calendar.DAY_OF_WEEK, 1); //定位到上周
        return cal.getTime();
    }

    /**
     * 获取上周一
     */
    public static Date getBeforWeekMonday(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.add(Calendar.WEEK_OF_YEAR, -1);// 上周
        cal.set(Calendar.DAY_OF_WEEK, 2);  //设为周几 2为周一 1位周末
        return cal.getTime();
    }

    /**
     * 获取上周日
     */
    public static Date getBeforWeekSunday(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.setFirstDayOfWeek(Calendar.MONDAY); //将每周第一天设为周一
        cal.add(Calendar.WEEK_OF_MONTH, -1);//周数减一，即上周
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//日子设为星期天
        return cal.getTime();
    }


    /**
     * 格式化时间 return Date 时间格式为：yyyy-MM-dd HH:mm:ss 2017-04-02 00:00:00:0
     */
    public static Date getDataOfZoreHMS(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /***
     * 得到上个月第一天
     * @param currDate
     * @return Date 返回格式化后的上月第一天
     */
    public static Date getFirstDayOfBeforeMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /***
     * 得到上个月最后一天
     * @param currDate
     * @return Date 返回格式化后的上月最后一天
     */
    public static Date getLastDayOfBeforeMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 得到格式化后的下月第一天，格式为yyyy-MM-dd，如2006-02-01
     *
     * @param
     * @return String 返回格式化后的下月第一天，格式为yyyy-MM-dd，如2006-02-01
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     */
    public static String getFirstDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +1);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
     *
     * @param currDate 要格式化的日期
     * @return String 返回格式化后的当月第一天，格式为yyyy-MM-dd，如2006-02-01
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     */
    public static String getFirstDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int firstDay = cal.getMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到格式化后的当月最后一天，格式为yyyy-MM-dd，如2006-02-28
     *
     * @param currDate 要格式化的日期
     * @return String 返回格式化后的当月最后一天，格式为yyyy-MM-dd，如2006-02-28
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     */
    public static String getLastDayOfMonth(Date currDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currDate);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到格式化后的当月最后一天，格式为yyyy-MM-dd，如2006-02-28
     *
     * @param
     * @return String 返回格式化后的当月最后一天，格式为yyyy-MM-dd，如2006-02-28
     * @see Calendar#getMinimum(int)
     * @see #getFormatDate(Date, String)
     */
    public static String getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 得到日期的前或者后几小时
     *
     * @param iHour 如果要获得前几小时日期，该参数为负数； 如果要获得后几小时日期，该参数为正数
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几小时
     * @see Calendar#add(int, int)
     */
    public static Date getDateBeforeOrAfterHours(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.HOUR_OF_DAY, iHour);
        return cal.getTime();
    }

    /**
     * 判断日期是否在当前周内
     *
     * @param curDate
     * @param compareDate
     * @return
     */
    public static boolean isSameWeek(Date curDate, Date compareDate) {
        if (curDate == null || compareDate == null) {
            return false;
        }

        Calendar calSun = Calendar.getInstance();
        calSun.setTime(getFormatDateToDate(curDate));
        calSun.set(Calendar.DAY_OF_WEEK, 1);

        Calendar calNext = Calendar.getInstance();
        calNext.setTime(calSun.getTime());
        calNext.add(Calendar.DATE, 7);

        Calendar calComp = Calendar.getInstance();
        calComp.setTime(compareDate);
        if (calComp.after(calSun) && calComp.before(calNext)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 时间查询时,结束时间的 23:59:59
     */
    public static String addDateEndfix(String datestring) {
        if ((datestring == null) || "".equals(datestring)) {
            return null;
        }
        return datestring + " 23:59:59";
    }

    public static String addDateBeginfix(String datestring) {
        if ((datestring == null) || "".equals(datestring)) {
            return null;
        }
        return datestring + " 00:00:00";
    }

    /**
     * 返回格式化的日期
     *
     * @param dateStr 格式"yyyy-MM-dd 23:59:59";
     * @return
     */
    public static Date getFormatDateEndfix(String dateStr) {
        dateStr = addDateEndfix(dateStr);
        return getFormatDateTime(dateStr);
    }

    /**
     * 返回格式化的日期
     *
     * @param datePre 格式"yyyy-MM-dd HH:mm:ss";
     * @return
     */
    public static Date formatEndTime(String datePre) {
        if (datePre == null)
            return null;
        String dateStr = addDateEndfix(datePre);
        return getFormatDateTime(dateStr);
    }

    // date1加上compday天数以后的日期与当前时间比较，如果大于当前时间返回true，否则false
    public static Boolean compareDay(Date date1, int compday) {
        if (date1 == null)
            return false;
        Date dateComp = getDateBeforeOrAfter(date1, compday);
        Date nowdate = new Date();
        if (dateComp.after(nowdate))
            return true;
        else
            return false;
    }


    /**
     * 进行时段格式转换，对于输入的48位的01串，将进行如下操作： <li>
     * 1.先将输入中每个0变成两个0，每个1变成2个1，形成一个96位的二进制串。</li> <li>
     * 2.将上述的96位的二进制串分成3组，每组32位。</li> <li>3.将每个32位的二进制串转换成一个8位的16进制串。</li>
     * <li>4.将3个8位的16进制串合并成一个串，中间以","分割。</li>
     *
     * @param timespan 一个48位的二进制串，如："011111111011111111111111111111111111111111111110"
     * @return 一个16进制串，每位间以","分割。如："3fffcfff,ffffffff,fffffffc"
     */
    public static String convertBinaryTime2Hex(String timespan) {
        if (timespan == null || timespan.equals("")) {
            return "";
        }

        String ret = "";
        String tmp = "";
        for (int i = 0; i < timespan.length(); i++) {
            tmp += timespan.charAt(i);
            tmp += timespan.charAt(i);
            // tmp += i;
            if ((i + 1) % 16 == 0) {
                if (!ret.equals("")) {
                    ret += ",";
                }
                Long t = Long.parseLong(tmp, 2);
                String hexStr = Long.toHexString(t);
                if (hexStr.length() < 8) {
                    int length = hexStr.length();
                    for (int n = 0; n < 8 - length; n++) {
                        hexStr = "0" + hexStr;
                    }
                }

                ret += hexStr;
                tmp = "";
            }
        }

        return ret;
    }

    /**
     * 进行时段格式转换，将输入的26位的2进制串转换成48位的二进制串。
     *
     * @param timespan 一个16进制串，每位间以","分割。如："3fffcfff,ffffffff,fffffffc"
     * @return 一个48位的二进制串，如："011111111011111111111111111111111111111111111110"
     */
    public static String convertHexTime2Binary(String timespan) {
        if (timespan == null || timespan.equals("")) {
            return "";
        }

        String tmp = "";
        String ret = "";
        String[] strArr = timespan.split(",");
        for (int i = 0; i < strArr.length; i++) {
            String binStr = Long.toBinaryString(Long.parseLong(strArr[i], 16));
            if (binStr.length() < 32) {
                int length = binStr.length();
                for (int n = 0; n < 32 - length; n++) {
                    binStr = "0" + binStr;
                }
            }
            tmp += binStr;
        }

        for (int i = 0; i < 48; i++) {
            ret += tmp.charAt(i * 2);
        }

        return ret;
    }

    /**
     * 进行时段格式转换，将输入的32位的10进制串转换成48位的二进制串。
     *
     * @param timespan 一个16进制串，每位间以","分割。如："1234567890,1234567890,1234567890c"
     * @return 一个48位的二进制串，如："011111111011111111111111111111111111111111111110"
     */
    public static String convertDecTime2Binary(String timespan) {
        if (timespan == null || timespan.equals("")) {
            return "";
        }

        String tmp = "";
        String ret = "";
        String[] strArr = timespan.split(",");
        for (int i = 0; i < strArr.length; i++) {
            String binStr = Long.toBinaryString(Long.parseLong(strArr[i], 10));
            if (binStr.length() < 32) {
                int length = binStr.length();
                for (int n = 0; n < 32 - length; n++) {
                    binStr = "0" + binStr;
                }
            }
            tmp += binStr;
        }

        for (int i = 0; i < 48; i++) {
            ret += tmp.charAt(i * 2);
        }

        return ret;
    }

    /**
     * 进行时段格式转换，对于输入的48位的01串，将进行如下操作： <li>
     * 1.先将输入中每个0变成两个0，每个1变成2个1，形成一个96位的二进制串。</li> <li>
     * 2.将上述的96位的二进制串分成3组，每组32位。</li> <li>3.将每个32位的二进制串转换成一个10位的10进制串。</li>
     * <li>4.将3个8位的16进制串合并成一个串，中间以","分割。</li>
     *
     * @param timespan 一个48位的二进制串，如："011111111011111111111111111111111111111111111110"
     * @return 一个16进制串，每位间以","分割。如："1234567890,1234567890,1234567890"
     */
    public static String convertBinaryTime2Dec(String timespan) {
        if (timespan == null || timespan.equals("")) {
            return "";
        }

        String ret = "";
        String tmp = "";
        for (int i = 0; i < timespan.length(); i++) {
            tmp += timespan.charAt(i);
            tmp += timespan.charAt(i);
            // tmp += i;
            if ((i + 1) % 16 == 0) {
                if (!ret.equals("")) {
                    ret += ",";
                }
                Long t = Long.parseLong(tmp, 2);
                String decStr = Long.toString(t);
                if (decStr.length() < 10) {
                    int length = decStr.length();
                    for (int n = 0; n < 10 - length; n++) {
                        decStr = "0" + decStr;
                    }
                }

                ret += decStr;
                tmp = "";
            }
        }

        return ret;
    }

    /**
     * 计算指定日期+addMonth月+15号 返回格式"2008-02-15"
     *
     * @param date
     * @param addMonth
     * @param monthDay
     * @return
     */
    public static String genericSpecdate(Date date, int addMonth, int monthDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, addMonth);
        cal.set(Calendar.DAY_OF_MONTH, monthDay);
        return getFormatDate(cal.getTime(), DATE_FORMAT);
    }

    /**
     * 获得以今天为单位若干天以前或以后的日期的标准格式"Wed Feb 20 00:00:00 CST 2008"，是0点0分0秒。
     *
     * @param idx
     * @return
     */
    public static Date getDateBeforeOrAfterV2(int idx) {
        return getDateBeforeOrAfter(getFormatDateToDate(getCurrDate()), idx);
    }

    /**
     * 获得给定时间若干秒以前或以后的日期的标准格式。
     *
     * @param curDate
     * @param seconds
     * @return curDate
     */
    public static Date getSpecifiedDateTimeBySeconds(Date curDate, int seconds) {
        long time = (curDate.getTime() / 1000) + seconds;
        curDate.setTime(time * 1000);
        return curDate;
    }

    /**
     * 获得给定时间若干秒以前或以后的日期的标准格式。
     *
     * @param curDate
     * @param seconds
     * @return curDate
     */
    public static Date addSeconds(Date curDate, int seconds) {
        long time = (curDate.getTime() / 1000) + seconds;
        Date date = new Date(time * 1000);
        return date;
    }

    /**
     * 获得给定日期当天23点59分59秒的标准格式。
     *
     * @param curDate
     * @return curDate
     */
    public static Date getSpecifiedDateTime_235959(Date curDate) {
        return getSpecifiedDateTimeBySeconds(getFormatDateToDate(curDate), 24 * 60 * 60 - 1);
    }

    public static String getSpecifiedDateTime_month(Date curDate) {
        return getFormatDateTime(curDate, "MM.dd");
    }

    // change by bbq
    public static final String dtSimple = "yyyy-MM-dd";

    /**
     * alahan add 20050825 获取传入时间相差的日期
     *
     * @param dt   传入日期，可以为空
     * @param diff 需要获取相隔diff天的日期 如果为正则取以后的日期，否则时间往前推
     * @return
     */
    public static String getDiffStringDate(Date dt, int diff) {
        Calendar ca = Calendar.getInstance();

        if (dt == null) {
            ca.setTime(new Date());
        } else {
            ca.setTime(dt);
        }

        ca.add(Calendar.DATE, diff);
        return dtSimpleFormat(ca.getTime());
    }

    /**
     * 加天数
     *
     * @param dt
     * @param diff
     * @return
     */
    public static Date addDay(Date dt, int diff) {
        Calendar ca = Calendar.getInstance();

        if (dt == null) {
            ca.setTime(new Date());
        } else {
            ca.setTime(dt);
        }

        ca.add(Calendar.DATE, diff);
        return ca.getTime();
    }

    /**
     * alahan add 20050825 获取传入时间相差的日期
     *
     * @param dt   传入日期，可以为空
     * @param diff 需要获取相隔diff天的日期 如果为正则取以后的日期，否则时间往前推
     * @return yyyy.MM.dd
     */
    public static String getDiffStringPointDate(Date dt, int diff, String pattern) {
        Calendar ca = Calendar.getInstance();

        if (dt == null) {
            ca.setTime(new Date());
        } else {
            ca.setTime(dt);
        }

        ca.add(Calendar.DATE, diff);

        SimpleDateFormat df = new SimpleDateFormat(pattern);//设置日期格式
        return df.format(ca.getTime());
    }

    /**
     * yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static final String dtSimpleFormat(Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(dtSimple).format(date);
    }

    /**
     * yyyy.MM.dd
     *
     * @param date
     * @return
     */
    public static final String pointSimpleFormat(Date date) {
        if (date == null) {
            return "";
        }

        return getFormat(DATE_FORMAT_POINT).format(date);
    }

    // SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 取得多个日期中间隔的最大天数
     *
     * @param startDateAndEndDate
     * @return
     * @author Alvise
     */
    public static int maxContinuousDays(Date[][] startDateAndEndDate) {
        // 冒泡排序
        for (int i = 0; i < startDateAndEndDate.length - 1; i++) {
            for (int j = 0; j < startDateAndEndDate.length - i - 1; j++) {
                if (DateUtils.getDaysBetweenDates(startDateAndEndDate[j + 1][0],
                        startDateAndEndDate[j][0]) > 0) {
                    Date[] tempDate = startDateAndEndDate[j];
                    startDateAndEndDate[j] = startDateAndEndDate[j + 1];
                    startDateAndEndDate[j + 1] = tempDate;
                }
            }
        }

        //         for (int i = 0; i < startDateAndEndDate.length; i++) {
        //         if (startDateAndEndDate[i][0] == null)
        //         break;
        //         System.out.println(DateTimeUtil.getFormatDate(
        //         startDateAndEndDate[i][0]) + ","
        //         + DateTimeUtil.getFormatDate(startDateAndEndDate[i][1]));
        //         }
        //
        //         System.out.println(
        //         "===========================================");

        // 合并连续的时间段
        int j = 0;
        Date[][] startDateAndEndDateNew = new Date[startDateAndEndDate.length][2];
        for (int i = 0; i < startDateAndEndDateNew.length; i++) {
            if (j >= startDateAndEndDate.length)
                break;

            startDateAndEndDateNew[i] = startDateAndEndDate[j];
            j++;
            while (j < startDateAndEndDate.length) {
                if (DateUtils.getDaysBetweenDates(startDateAndEndDateNew[i][1],
                        startDateAndEndDate[j][0]) > 0) {
                    break;
                } else if (DateUtils.getDaysBetweenDates(startDateAndEndDateNew[i][1],
                        startDateAndEndDate[j][1]) > 0) {
                    startDateAndEndDateNew[i][1] = startDateAndEndDate[j][1];
                    j++;
                } else if (DateUtils.getDaysBetweenDates(startDateAndEndDateNew[i][1],
                        startDateAndEndDate[j][1]) <= 0) {
                    j++;
                }

            }
        }

        //         for (int i = 0; i < startDateAndEndDateNew.length; i++) {
        //            if (startDateAndEndDateNew[i][0] == null)
        //                break;
        //            System.out.println(DateTimeUtil.getFormatDate(startDateAndEndDateNew[i][0]) + ","
        //                    + DateTimeUtil.getFormatDate(startDateAndEndDateNew[i][1]));
        //        }

        // 选择法排序
        int maxDays = 0;
        for (int i = 0; i < startDateAndEndDateNew.length - 1; i++) {
            Date curEndDate = startDateAndEndDateNew[i][1];
            Date nextStartDate = startDateAndEndDateNew[i + 1][0];
            if (curEndDate == null || nextStartDate == null) {
                break;
            }

            int temDays = DateUtils.getDaysBetweenDates(curEndDate, nextStartDate);
            if (temDays > maxDays) {
                maxDays = temDays;
            }
        }
        return maxDays;
    }

    /**
     * 取得多个日期中间隔的最大天数,这里的参数是用 ","和";"分割的字符字符串例如 "2008-08-03,2008-08-04;"
     *
     * @param dateStr
     * @return
     * @author Alvise
     */
    public static int maxContinuousDays(String dateStr) {
        String[] seDate = dateStr.split(";");
        Date[][] startDateAndEndDate = new Date[seDate.length][2];

        for (int i = 0; i < seDate.length; i++) {
            String[] tempDate = seDate[i].split(",");
            startDateAndEndDate[i][0] = DateUtils.getFormatDate(tempDate[0]);
            startDateAndEndDate[i][1] = DateUtils.getFormatDate(tempDate[1]);
        }

        return maxContinuousDays(startDateAndEndDate);

    }

    /**
     * 判断时间段1和时间段2是否有交集
     *
     * @param begintimeOne
     * @param endtimeOne
     * @param begintimeTwo
     * @param endtimeTwo
     * @return true:有交集,false:没有交集
     */
    public static boolean isConfilct(String begintimeOne, String endtimeOne, String begintimeTwo,
                                     String endtimeTwo) {
        Date beginOne = getFormatDate(begintimeOne);
        Date endOne = getFormatDate(endtimeOne);
        Date beginTwo = getFormatDate(begintimeTwo);
        Date endTwo = getFormatDate(endtimeTwo);
        if ((beginOne.compareTo(beginTwo) <= 0 && endOne.compareTo(beginTwo) >= 0)
                || (beginOne.compareTo(endTwo) <= 0 && endOne.compareTo(endTwo) >= 0)
                || (beginTwo.compareTo(beginOne) <= 0 && endTwo.compareTo(beginOne) >= 0)
                || (beginTwo.compareTo(endOne) <= 0 && endTwo.compareTo(endOne) >= 0)) {
            return true;
        }
        return false;
    }

    /**
     * 取得最早可购买时间
     *
     * @param busytimes 被购买时间,格式为2008-08-06,2008-08-06;2008-08-9,2008-08-12;2008-08-14,2008-08-22;2008-09-04,2008-09-04
     * @param days      购买时长
     * @return 最高可购买时间
     */
    public static String getCansellTime(String busytimes, int days) {
        Map<String, Integer> dayMap = new HashMap<String, Integer>();
        String[] busytimeArr = StringUtils.split(busytimes, ";");
        for (int i = 0; i < busytimeArr.length; i++) {
            String[] time = StringUtils.split(busytimeArr[i], ",");
            Date d1 = getFormatDateTime(time[0], DATE_FORMAT);
            Date d2 = getFormatDateTime(time[1], DATE_FORMAT);
            while (d1.compareTo(d2) <= 0) {
                dayMap.put(getFormatDate(d1), null);
                d1 = getDateBeforeOrAfter(d1, 1);
            }
        }

        Date lastDate = getFormatDateTime(getFormatDate(getDateBeforeOrAfter(29)), DATE_FORMAT);
        Date beginDate = getFormatDateTime(getFormatDate(getDateBeforeOrAfter(2)), DATE_FORMAT);
        Date endDate = getDateBeforeOrAfter(beginDate, days - 1);

        while (beginDate.compareTo(lastDate) <= 0) {
            boolean conflict = false;
            List<Date> daysList = getDaysListBetweenDates(beginDate, endDate);
            for (Date d : daysList) {
                if (dayMap.containsKey(getFormatDate(d))) {
                    conflict = true;
                    break;
                }
            }
            if (!conflict) {
                break;
            }
            beginDate = getDateBeforeOrAfter(beginDate, 1);
            endDate = getDateBeforeOrAfter(beginDate, days - 1);
        }
        return getFormatDate(beginDate);
    }

    /**
     * 时间段限制方法（三个月）
     * 比较YYYY-MM—DD
     *
     * @param from
     * @param to
     * @return
     */
    public static Boolean inspectionTime(Date from, Date to) {
        //得到现在时间的前三个月 
        Date dNow = new Date();
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTime(dNow);
        calendarNow.add(calendarNow.MONTH, -3);
        dNow = calendarNow.getTime();
        from = addStartDate(from);//
        to = addStartDate(to);//
        // 当前时间
        Date now = new Date();
        if (from != null && to != null) {
            //得到结束时间的前三个月 
            Date toTime = to;
            Calendar calendarTo = Calendar.getInstance();
            calendarTo.setTime(toTime);
            calendarTo.add(Calendar.MONTH, -3);
            toTime = calendarTo.getTime();
            if ((from.getTime() > to.getTime()) || (from.getTime() < toTime.getTime())
                    || (to.getTime() > now.getTime()) || (from.getTime() > now.getTime())) {
                return false;
            } else {
                return true;
            }
        } else if (from != null && to == null) {
            if (from.getTime() > now.getTime() || from.getTime() < dNow.getTime()) {
                return false;
            } else
                return true;
        } else if (from == null && to != null) {
            if (to.getTime() > now.getTime() || to.getTime() < dNow.getTime()) {
                return false;
            } else
                return true;
        } else
            return true;
    }


    public static Date addEndDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat endSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if (null == date) {
            return null;
        } else {
            String str = sdf.format(date);
            str = str + " 23:59:59";
            try {
                return endSdf.parse(str);
            } catch (ParseException e) {
                return null;
            }

        }
    }


    public static Date addStartDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        if (date == null) {
            return null;
        }

        String str = sdf.format(date);
        str = str + " 00:00:00";
        try {
            return startSdf.parse(str);
        } catch (ParseException e) {
            return null;
        }

    }

    /**
     * 转换成es的时间格式
     *
     * @param date
     * @return
     */
    public static String getESDateStr(Date date) {
        if (null == date) {
            return null;
        }
        SimpleDateFormat startSdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return startSdf.format(date);
    }

    /**
     * String转成Es的时间格式
     *
     * @param date
     * @return
     */
    public static String getESStr(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }

        Pattern p = Pattern.compile("\\s");
        Matcher m = p.matcher(date);
        String result = m.replaceAll("T");
        result = result; //+ ".000";
        return result;

    }

    /**
     * 获取时间段内所有日期
     */
    public static List<Date> getDatesBetweenDate(String start, String end) {
        Date startDate = getFormatDate(start);
        Date endDate = getFormatDate(end);

        List<Date> dateList = new ArrayList<>();
        while (endDate.compareTo(startDate) >= 0) {
            dateList.add(startDate);
            startDate = addDay(startDate, 1);
        }
        return dateList;
    }

    /***
     * 整秒数转换为 天 时 分 秒
     * 1200000 秒转换为 13天21小时20分钟0秒
     * @param mss
     * @return
     */
    public static String transfMssToDate(Integer mss) {
        String DateTimes = null;
        Integer days = mss / (60 * 60 * 24);
        Integer hours = (mss % (60 * 60 * 24)) / (60 * 60);
        Integer minutes = (mss % (60 * 60)) / 60;
        Integer seconds = mss % 60;

        if (days > 0) {

            DateTimes = String.format("%s天%s小时%s分%s秒", days, hours, minutes, seconds);

        } else if (hours > 0) {

            DateTimes = String.format("%s小时%s分%s秒", hours, minutes, seconds);

        } else if (minutes > 0) {

            DateTimes = String.format("%s分%s秒", minutes, seconds);
        } else {

            DateTimes = String.format("%s秒", seconds);
        }
        return DateTimes;
    }

}

