package com.hxqh.eam.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ocean lin on 2017/7/9.
 */
public class StaticUtils {


    // 默认时间格式
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    // 时间格式化
    private static DateFormat dateTimeFormat = null;

    // 时间格式YYYY-MM
    public static final String DATETIME_YYYY_MM = "yyyy-MM";
    private static DateFormat yyyyMmFormat = null;

    // 时间格式YYYY-MM-dd
    public static final String DATETIME_YYYY_MM_DD = "yyyy-MM-dd";
    private static DateFormat yyyyMmDdFormat = null;

    static Map<String, String> map = new HashMap<>();

    static {
        dateTimeFormat = new SimpleDateFormat(DATETIME_DEFAULT_FORMAT);
        yyyyMmFormat = new SimpleDateFormat(DATETIME_YYYY_MM);
        yyyyMmDdFormat = new SimpleDateFormat(DATETIME_YYYY_MM_DD);
    }

    static {
        map.put("METRO", "1");
        map.put("PE", "2");
        map.put("TERA", "3");
    }

    /**
     * 日期格式化yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDateTimeFormat(Date date) {
        return dateTimeFormat.format(date);
    }

    /**
     * 日期格式化yyyy-MM
     *
     * @param date
     * @return
     */
    public static String getYearMonthFormat(Date date) {
        return yyyyMmFormat.format(date);
    }

    /**
     * 日期格式化yyyy-MM-dd
     *
     * @param date
     * @return
     */
    public static String getYearMonthDayFormat(Date date) {
        return yyyyMmDdFormat.format(date);
    }

    public static Map<String, String> getMap() {
        return map;
    }


    //获取本周的开始时间
    public static Date getBeginDayOfWeek() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }

        //控制开始第一天是星期一（2）还是星期日（1）
        cal.add(Calendar.DATE, 1 - dayofweek);
        return getDayStartTime(cal.getTime());
    }


    //获取本周的结束时间
    public static Date getEndDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getBeginDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        Date weekEndSta = cal.getTime();
        return getDayEndTime(weekEndSta);
    }

    //获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    //获取某个日期的结束时间
    public static Timestamp getDayEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d) calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

}
