package com.lqw.library_util.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class DateUtil {

    public static String timeToHMS(int time) {
        String h = String.valueOf(time / 60 / 60 % 60).equals("0") ? "" : String.valueOf(time / 60 / 60 % 60) + " : ";
        String m = String.valueOf(time / 60 % 60);
        String s = String.valueOf(time % 60);
        return h + m + " : " + s;
    }


    public static String TimeYMD(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(time * 1000L));
        return times;
    }


    /**
     * 时间戳转换成具体的日期
     *
     * @param time
     * @return
     */
    public static String timetYMDHS(int time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(time * 1000L));
        return times;

    }

    public static String timetYMDHS(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String times = sdr.format(new Date(time));
        return times;

    }

    /**
     * 时间戳转换成具体的日期  格式不一样
     *
     * @param time
     * @return
     */
    public static String timeToYMDHS(int time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(time * 1000L));
        return times;
    }


    public static Map<String, Long> calculateDistance(long milliseconds) {
        Map<String, Long> distance = new HashMap<String, Long>();
        final long Day_milliseconds = 24L * 60 * 60 * 1000;
        final long Hour_milliseconds = 60L * 60 * 1000;
        final long Minute_milliseconds = 60L * 1000;
        final long Second_milliseconds = 1000L;

        long day = milliseconds / Day_milliseconds;
        milliseconds -= day * Day_milliseconds;
        long hour = milliseconds / Hour_milliseconds;
        milliseconds -= hour * Hour_milliseconds;
        long minute = milliseconds / Minute_milliseconds;
        milliseconds -= minute * Minute_milliseconds;
        long second = milliseconds / Second_milliseconds;

        distance.put("day", day);
        distance.put("hour", hour);
        distance.put("minute", minute);
        distance.put("second", second);

        return distance;
    }

    public static Date getHour(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.set(year, month, day, hour, 0, 0);

        long time = calendar.getTimeInMillis();
        time = time / 1000 * 1000;

        return new Date(time);
    }

    /**
     * 获得第二天
     *
     * @param date 该日期是第二天0点
     * @return
     * @throws Exception
     */
    public static Date getNextDay(Date date) throws Exception {
        long time = date.getTime();
        time += 24L * 60 * 60 * 1000;

        Date nexDay = new Date(time);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nexDay);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year, month, day, 0, 0, 0);

        time = calendar.getTimeInMillis();
        time = time / 1000 * 1000;

        return new Date(time);
    }

    public static Date get24HBeforeDay(Date date) {
        long time = date.getTime();
        time -= 24L * 60 * 60 * 1000;
        return new Date(time);
    }

    public static Date getToday() {
        Date myDate = new Date();

        return getToday(myDate);
    }

    public static Date get24HAfterDay(Date date) {
        long time = date.getTime();
        time += 24L * 60 * 60 * 1000;
        return new Date(time);
    }

    public static int getDaysTo1970(Date date) {
        long millisecond = 24L * 60 * 60 * 1000;
        return (int) (date.getTime() / millisecond);
    }

    public static Date getToday(Date myDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year, month, day, 0, 0, 0);

        long time = calendar.getTimeInMillis();
        time = time / 1000 * 1000;

        return new Date(time);
    }

    //获得上个小时的整点
    public static Date getHourBefore() {
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.set(year, month, day, hour, 0, 0);

        calendar.add(Calendar.HOUR_OF_DAY, -1);

        long time = calendar.getTimeInMillis();
        time = time / 1000 * 1000;

        return new Date(time);
    }

    public static Date getMonth(Date myDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);

        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year, month, 1, 0, 0, 0);

        long time = calendar.getTimeInMillis();
        time = time / 1000 * 1000;

        return new Date(time);
    }

    public static Date getYesterday() {
        Date today = getToday();
        return get24HBeforeDay(today);
    }

    public static Date getDayBeforeYesterday() {
        Date yesterday = getYesterday();
        return get24HBeforeDay(yesterday);
    }

    public static int getMonth() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.MONTH);

    }

    public static Date getYmdDate(String dateString) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatDate.parse(dateString);
        } catch (Exception e) {
        }
        return date;
    }

    public static String formatYString(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy");
        String dateStr = null;
        try {
            dateStr = formatDate.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }

    public static String formatYmString(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM");
        String dateStr = null;
        try {
            dateStr = formatDate.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }

    public static String formatYmdString(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = null;
        try {
            dateStr = formatDate.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }

    public static String formatYmdHmsString(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = null;
        try {
            dateStr = formatDate.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }

    public static String formatYmdCNString(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy年MM月dd日");
        String dateStr = null;
        try {
            dateStr = formatDate.format(date);
        } catch (Exception e) {
        }
        return dateStr;
    }

    public static Date getYmdHmsDate(String dateString) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formatDate.parse(dateString);
        } catch (Exception e) {
        }
        return date;
    }

    public static Date getYmdHmDate(String dateString) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = formatDate.parse(dateString);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 返回二位的时间如"09",在个位数时间前补零
     *
     * @param t
     * @return
     */
    public static String getFormatTime(int t) {
        DecimalFormat df = new DecimalFormat("00");
        return df.format(t);
    }

    /**
     * 3天前的时间
     *
     * @return
     */
    public static Date getThreeDateBeforeNow() {
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 3);
        return calendar.getTime();
    }

    /**
     * 获得当天的某个小时的整点DATE
     *
     * @param hour
     * @return
     */
    public static Date getFloorHourBefore(int hour) {
        Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        calendar.set(year, month, day, hour, 0, 0);

        long time = calendar.getTimeInMillis();
        time = time / 1000 * 1000;

        return new Date(time);
    }

    public static String getCurrentSystemTime() {
        long time = System.currentTimeMillis() / 1000;
        return String.valueOf(time);
    }

//    public static String formatBetweenDate(Date startDate, Date endDate) {
//
//        DateTime from = new DateTime(startDate);
//        DateTime to = new DateTime(endDate);
//        int days = Days.daysBetween(from, to).getDays();
//        String format = "";
//        if (days > 0) {
//            from = from.plusDays(days);
//            format += days + "天";
//        }
//        from.plusDays(days);
//        int hours = Hours.hoursBetween(from, to).getHours();
//        if (hours > 0) {
//            from = from.plusHours(hours);
//            format += hours + "小时";
//        }
//        from.plusHours(hours);
//        int minutes = Minutes.minutesBetween(from, to).getMinutes();
//        if (minutes > 0) {
//            format += minutes + "分钟";
//        }
//        from = from.plusMinutes(minutes);
//        int seconds = Seconds.secondsBetween(from, to).getSeconds();
//        if (seconds > 0) {
//            format += seconds + "秒";
//        }
//        return format;
//
//    }
//    public static void main(String[] args) {
//        System.out.println(getThreeDateBeforeNow().before(new Date()));
//    }


    /**
     * 时间戳格式转换
     */
    static String dayNames[] = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

    public static String getNewChatTime(String timesampd) {
        long timesamp = getYmdHmsDate(timesampd).getTime();
        String result = "";
        Calendar todayCalendar = Calendar.getInstance();
        Calendar otherCalendar = Calendar.getInstance();
        otherCalendar.setTimeInMillis(timesamp);

        String timeFormat = "M月d日 HH:mm";
        String yearTimeFormat = "yyyy年M月d日 HH:mm";
        String am_pm = "";
        int hour = otherCalendar.get(Calendar.HOUR_OF_DAY);
        if (hour >= 0 && hour < 6) {
            am_pm = "凌晨";
        } else if (hour >= 6 && hour < 12) {
            am_pm = "早上";
        } else if (hour == 12) {
            am_pm = "中午";
        } else if (hour > 12 && hour < 18) {
            am_pm = "下午";
        } else if (hour >= 18) {
            am_pm = "晚上";
        }
        timeFormat = "M月d日 " + am_pm + "HH:mm";
        yearTimeFormat = "yyyy年M月d日 " + am_pm + "HH:mm";

        boolean yearTemp = todayCalendar.get(Calendar.YEAR) == otherCalendar.get(Calendar.YEAR);
        if (yearTemp) {
            int todayMonth = todayCalendar.get(Calendar.MONTH);
            int otherMonth = otherCalendar.get(Calendar.MONTH);
            if (todayMonth == otherMonth) {//表示是同一个月
                int temp = todayCalendar.get(Calendar.DATE) - otherCalendar.get(Calendar.DATE);
                switch (temp) {
                    case 0:
                        result = getHourAndMin(timesamp);
                        break;
                    case 1:
                        result = "昨天 " + getHourAndMin(timesamp);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        int dayOfMonth = otherCalendar.get(Calendar.WEEK_OF_MONTH);
                        int todayOfMonth = todayCalendar.get(Calendar.WEEK_OF_MONTH);
                        if (dayOfMonth == todayOfMonth) {//表示是同一周
                            int dayOfWeek = otherCalendar.get(Calendar.DAY_OF_WEEK);
                            if (dayOfWeek != 1) {//判断当前是不是星期日     如想显示为：周日 12:09 可去掉此判断
                                result = dayNames[otherCalendar.get(Calendar.DAY_OF_WEEK) - 1] + getHourAndMin(timesamp);
                            } else {
                                result = getTime(timesamp, timeFormat);
                            }
                        } else {
                            result = getTime(timesamp, timeFormat);
                        }
                        break;
                    default:
                        result = getTime(timesamp, timeFormat);
                        break;
                }
            } else {
                result = getTime(timesamp, timeFormat);
            }
        } else {
            result = getYearTime(timesamp, yearTimeFormat);
        }
        return result;
    }

    /**
     * 当天的显示时间格式
     *
     * @param time
     * @return
     */
    public static String getHourAndMin(long time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(time));
    }

    /**
     * 不同一周的显示时间格式
     *
     * @param time
     * @param timeFormat
     * @return
     */
    public static String getTime(long time, String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.format(new Date(time));
    }

    /**
     * 不同年的显示时间格式
     *
     * @param time
     * @param yearTimeFormat
     * @return
     */
    public static String getYearTime(long time, String yearTimeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(yearTimeFormat);
        return format.format(new Date(time));
    }


    /**
     * 获取上一年
     *
     * @return
     */
    public static Date getLastYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        return y;
    }


    /**
     * 获取上一年时间字符串
     *
     * @return
     */
    public static String getLastYearString() {
        return formatYString(getLastYear());
    }

    /**
     *
     * @return
     */
    public static Date getLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        return date;
    }


    /**
     * 获取上个月时间字符串
     * @return
     */
    public static String getLastMonthString() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        return formatYmString(date);
    }

}