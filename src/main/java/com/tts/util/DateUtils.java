package com.tts.util;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtils
{
  public static String[] TIME_PATTERNS = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" };

  public static String getDate()
  {
    return getDate("yyyy-MM-dd");
  }
  public static String getDate(int plusDay) {
    return getDate("yyyy-MM-dd", plusDay);
  }

  public static String getDate(String pattern)
  {
    return new DateTime().toString(pattern);
  }

  public static String getDate(String pattern, String time, int plusDay) {
    return new DateTime(time).plusDays(plusDay).toString(pattern);
  }

  public static String getDate(String pattern, int plusDay) {
    return new DateTime().plusDays(plusDay).toString(pattern);
  }

  public static String date2str(Date date, Object[] pattern) {
    DateTime dt = null;

    if (date != null)
      dt = new DateTime(date);
    else {
      return null;
    }
    return formatDate(dt, pattern);
  }

  public static Date str2Date(String date, Object[] pattern) {
    DateTime dt = null;

    if (StringUtils.isNotBlank(date))
      dt = new DateTime(date);
    else {
      return null;
    }
    return formatToDate(dt, new Object[0]);
  }
  public static Date strToDate(String date) {
    return strToDate(date, "yyyy-MM-dd HH:mm");
  }
  public static Date strToDate(String date, String pattern) {
    DateTime time = DateTimeFormat.forPattern(pattern).parseDateTime(date).withZone(DateTimeZone.getDefault());
    return time.toDate();
  }

  public static String formatDate(DateTime dt, Object[] pattern)
  {
    String formatDate = null;

    if ((pattern != null) && (pattern.length > 0))
      formatDate = dt.toString(pattern[0].toString());
    else {
      formatDate = dt.toString("yyyy-MM-dd");
    }

    return formatDate;
  }

  public static Date formatToDate(DateTime dt, Object[] pattern) {
    return new DateTime(formatDate(dt, pattern)).toDate();
  }

  public static String getTimestamp() {
    return new DateTime().withZone(DateTimeZone.forID("Asia/Shanghai")).toLocalDateTime().toDateTime(DateTimeZone.UTC).getMillis() + "";
  }

  public static String getTime()
  {
    return formatDate(new DateTime(), new Object[] { "HH:mm:ss" });
  }

  public static String getDateTime()
  {
    return formatDate(new DateTime(), new Object[] { "yyyy-MM-dd HH:mm:ss" });
  }

  public static String getYear()
  {
    return Integer.toString(new DateTime().getYear());
  }

  public static String getMonth()
  {
    return Integer.toString(new DateTime().getMonthOfYear());
  }

  public static String getDay()
  {
    return Integer.toString(new DateTime().getDayOfMonth());
  }

  public static String getWeek()
  {
    return Integer.toString(new DateTime().getDayOfWeek());
  }

  public static String getWeek(DateTime dt) {
    String week = "";

    switch (dt.getDayOfWeek()) {
    case 7:
      week = "星期日";
      break;
    case 1:
      week = "星期一";
      break;
    case 2:
      week = "星期二";
      break;
    case 3:
      week = "星期三";
      break;
    case 4:
      week = "星期四";
      break;
    case 5:
      week = "星期五";
      break;
    case 6:
      week = "星期六";
    }

    return week;
  }

  public static int getDiffYear(Date inTime, Date outTime)
  {
    if ((inTime == null) || (outTime == null)) return -1000;

    Period p = new Period(new DateTime(inTime), new DateTime(outTime), PeriodType.years());

    return p.getYears();
  }

  public static int getDiffDay(String inTime, String outTime)
  {
    if ((inTime == null) || (outTime == null)) return -1000;

    Period p = new Period(new DateTime(inTime), new DateTime(outTime), PeriodType.days());

    return p.getDays();
  }

  public static Date parseDate(Object str)
  {
    if (str == null) return null;

    return new DateTime(str).toDate();
  }

  public static long pastDays(Date date)
  {
    Period p = new Period(new DateTime(), new DateTime(date), PeriodType.days());

    return p.getDays();
  }
}
