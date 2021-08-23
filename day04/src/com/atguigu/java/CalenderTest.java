package com.atguigu.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

    /**
     * Calender日历类(抽象类)的使用：
     */
    @Test
    public void test1() {

        //1.实例化
        //方式一：创建子类GregorianCalendar对象
        //方式二：调用静态方法

        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getClass());//GregorianCalendar

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//返回此月第几天
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()

        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()  日历类 --> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime(): Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }

}
