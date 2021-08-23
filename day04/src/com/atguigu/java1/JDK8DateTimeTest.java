package com.atguigu.java1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * LocalDate、LocalTime、LocalDateTime 使用
 * <p>
 * localDataTime使用频率更高
 *
 * @author: 86173
 * @date: 2021/4/13 10:43
 */
public class JDK8DateTimeTest {

    @Test
    public void test1() {

        //now() :获取当前日期、时间、日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of()：
        LocalDateTime localDateTime1 = localDateTime.of(2021, 4, 13, 10, 48, 56);
        System.out.println(localDateTime1);

        //getXxx():
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonthValue());

        //withXxx(): 设置相关属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//13   不变性
        System.out.println(localDate1);//22

        LocalDateTime localDateTime2 = localDateTime.withHour(21);
        System.out.println(localDateTime2);

        //plusXxx(): 增加属性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDate);//4月
        System.out.println(localDateTime3);//7月
    }

    /**
     * Instant的使用
     */

    @Test
    public void test2() {
        Instant instant = Instant.now();
        System.out.println(instant);

        //时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970.01.01至当前毫秒数
        long toEpochMilli = instant.toEpochMilli();  //Date的getTime()
        System.out.println(toEpochMilli);

        //
        Instant instant1 = Instant.ofEpochMilli(1618283323071L);
        System.out.println(instant1);
    }

    /**
     * DateTimeFormatter:格式化解析日期时间
     * 类似simpleDateFormat
     */
    @Test
    public void test3() {

        // 预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);
        //解析： 字符串-->日期
        TemporalAccessor parse = formatter.parse("2021-04-13T11:19:09.377");
        System.out.println(parse);

        // 本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)



        //重点： 自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化：
        String str2 = formatter1.format(LocalDateTime.now());
        System.out.println(str2);//2021-04-13 11:32:24

        //解析：
        TemporalAccessor parse1 = formatter1.parse("2021-04-13 11:32:24");
        System.out.println(parse1);




    }

}
