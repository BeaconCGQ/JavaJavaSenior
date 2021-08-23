package com.atguigu.java1;

import org.junit.Test;

import java.util.Date;


/**
 * JDK 8 之前的日期和时间的API测试
 *
 * @author: 86173
 * @date: 2021/4/12 14:02
 */
public class DataTimeTest {

    //1.System类中的currentTimeMillis()
    @Test
    public void test1() {

        long time = System.currentTimeMillis();
//         System.out.println(time);//返回1970年1月1日0时0分0秒到目前时间差，单位：毫秒
        //此时间差成为时间戳
    }

     /*
     java.util.Data类
            |---java.sql.Data类  //对应数据库中日变量

     1.两个构造器使用

     2.两个方法使用:
        >toString():显示当前时间年月日时分秒
        >getTime():获取时间戳


      */

    @Test
    public void test2() {
        //构造器一：Data()：创建了一个对应当前时间的Data对象
        Date date1 = new Date();
        System.out.println(date1.toString());

        long time1 = date1.getTime();
        System.out.println(time1);//1618208249124

        //构造器二：创建指定时间的对象
        Date date2 = new Date(1618208249124L);
        System.out.println(date2.toString());

        //创建java.sql.Data对象
        java.sql.Date date3 = new java.sql.Date(1618208249124L);
        System.out.println(date3);//显示年月日

        //将Util对象转换为sql对象
        Date date4 = new java.sql.Date(1618208249124L);//多态
        //情况一：
        java.sql.Date date5 = (java.sql.Date) date4;//强转
        //情况二：
       Date date6 = new Date();
       java.sql.Date date7 = new java.sql.Date(date6.getTime());//将参数拿过来作为sql构造器参数转换

    }

}
