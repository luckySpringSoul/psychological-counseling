package com.rys.utils;

import org.springframework.util.ObjectUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 基于 Java 8 的日期时间工具类
 *
 * @author qubo
 */
public class Jdk8DateUtils {
    public static final String DATE = "yyyy-MM-dd";
    public static final String TIME = "HH:mm:ss";
    public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String YEAR_MONTH = "yyyy-MM";

    /**
     * 对 LocalDate 类型的日期进行格式化
     *
     * @param date    LocalDate 类型的日期
     * @param pattern 日期时间格式
     * @return
     */
    public static String date2String(LocalDate date, String pattern) {
        if (ObjectUtils.isEmpty(pattern)) {
            pattern = DATE;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String ret = formatter.format(date);
        return ret;
    }

    /**
     * 对 LocalDateTime 类型的日期时间进行格式化
     *
     * @param dateTime LocalDate 类型的日期时间
     * @param pattern  日期时间格式
     * @return
     */
    public static String datetime2String(LocalDateTime dateTime, String pattern) {
        if (ObjectUtils.isEmpty(pattern)) {
            pattern = DATE_TIME;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String ret = formatter.format(dateTime);
        return ret;
    }

    /**
     * 获取当前时间的秒值：10 位
     *
     * @return
     */
    public static Integer currentSecond() {
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+8");
        long second = dateTime.toEpochSecond(offset);
        return Long.valueOf(second).intValue();
    }

    /**
     * 获取当前时间的秒值：13 位
     *
     * @return
     */
    public static Integer currentMilli() {
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("+8");
        Instant instant = dateTime.toInstant(offset);
        long epochMilli = instant.toEpochMilli();
        return Long.valueOf(epochMilli).intValue();
    }

    /**
     * 将秒值转换为 LocalDateTime
     *
     * @return
     */
    public static LocalDateTime second2LocalDateTime(Integer second) {
        if (ObjectUtils.isEmpty(second)/* || Integer.valueOf(0).equals(second)*/) {
            return null;
        }
        ZoneOffset offset = ZoneOffset.of("+8");
        //ZoneOffset offset = ZoneOffset.ofHours(8);
        return LocalDateTime.ofEpochSecond(second, 0, offset);
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zone);
        Instant instant = zonedDateTime.toInstant();
        return Date.from(instant);
    }



    /*public static void main(String[] args) {
        System.out.println(new BigDecimal("60.25").multiply(new BigDecimal("100")).negate().intValue());
        System.out.println(Jdk8DateUtils.date2String(LocalDate.now(), "yyyy"));
        System.out.println(Jdk8DateUtils.date2String(LocalDate.now(), "MM-dd"));
        System.out.println(Jdk8DateUtils.date2String(LocalDate.now(), null));

        System.out.println("");
        System.out.println(Jdk8DateUtils.datetime2String(LocalDateTime.now(), "yyyy"));
        System.out.println(Jdk8DateUtils.datetime2String(LocalDateTime.now(), "MM-dd"));
        System.out.println(Jdk8DateUtils.datetime2String(LocalDateTime.now(), null));

        System.out.println("");
        System.out.println(second2LocalDateTime(0));
    }*/
}
