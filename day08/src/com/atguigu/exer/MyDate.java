package com.atguigu.exer;

/**
 * MyDate 类包含:
 * private 成员变量 year,month,day；并为每一个属性定义 getter, setter方法；
 *
 * @author: 86173
 * @date: 2021/4/17 17:57
 */
public class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate b) {
        int sumYear = this.getYear() - b.getYear();
        if (sumYear != 0) {
            return sumYear;
        }
        int sumMonth = this.getMonth() - b.getMonth();
        if (sumMonth != 0) {
            return sumMonth;
        }
        return this.getDay() - b.getDay();
    }
}
