package com.atguigu.exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
  *创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
  * TreeSet 需使用泛型来定义）
  * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
  * 1). 使 Employee 实现 Comparable 接口，并按 name 排序 -->test1
  * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。 --->test2
  *
  * @author: 86173
  * @date: 2021/4/17 18:00
  */
public class TreeTest {
    @Test
     public void test1(){

        TreeSet set = new TreeSet();

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

//        for(Object o: set){
//            System.out.println(o);
//        }

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    int sumYear = b1.getYear() - b2.getYear();
                    if(sumYear != 0){
                        return sumYear;
                    }
                    int sumMonth = b1.getMonth() - b2.getMonth();
                    if(sumMonth != 0){
                        return sumMonth;
                    }
                    return b1.getDay() - b2.getDay();

                }
                throw new RuntimeException("传入数据类型不一致");
            }
        };

        TreeSet set = new TreeSet(com);

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangchaowei",21,new MyDate(1978,12,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        for(Object o: set){
            System.out.println(o);
        }

    }
}
