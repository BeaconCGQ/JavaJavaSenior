package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
  *
  * jdk8.0之前的日期时间测试
  * 1.System类中currentTimeMillis();
  * 2.java.util.Date和子类java.sql.Date
  * 3.SimpleDateFormat
  * 4.Calender
  *
  *
  *
  *
  * @author: 86173
  * @date: 2021/4/12 20:00
  */
public class DataTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
       格式化： 日期 --> 字符串
       解析：   字符串 --> 日期

    2.SimpleDateFormat的实例化
     */
     @Test
    public void test1() throws ParseException {
         //实例化SimpleDateFormat：默认构造器
         SimpleDateFormat sdf = new SimpleDateFormat();

         //格式化日期
         Date date = new Date();
         System.out.println(date);//Mon Apr 12 20:07:29 CST 2021

         String format = sdf.format(date);
         System.out.println(format);//21-4-12 下午8:07

         //解析：
         String str = "21-4-12 下午20:11";
         Date date1 = sdf.parse(str);
         System.out.println(date1);

         System.out.println("******************");
         //指定方法格式化：带参构造器
         SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         String format1 = sdf1.format(date);
         System.out.println(format1);//2021-04-12 08:21:30

         //解析：
         Date date2 = sdf1.parse("2021-04-12 08:21:30");
         System.out.println(date2);

     }
}
