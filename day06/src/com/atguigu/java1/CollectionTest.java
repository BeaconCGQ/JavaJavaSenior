package com.atguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
  * 一、集合框架的概述
  *  1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器
  *     说明：此时存储，指的是内存层面的存储，不涉及持久化的存储(.txt,.jpg,.avi,数据库)
  *  2.数组在存储多个数据方法的特点：
  *       >初始化以后，长度就确定了
  *       >数组声明以后，数组元素类型就确定了
  *   缺点：
  *       >初始化胡，长度不可修改
  *       >数组提供方法有限，对于添加、删除、插入等操作不便
  *       >对于获取数组中实际元素的个数，没有提供现有方法
  *       >存储数据特点：有序、可重复
  *
  * 二、集合框架
  *      |----Collection接口：单列集合，存储一个一个的对象
  *          |----List接口：存储有序、可重复数据    --->“动态数组”
  *               |----ArrayList、LinkedList、Vector
  *
  *          |----Set接口：存储无序、不可重复数据   --->高中数学的集合
  *               |----HashSet、LinkedHashSet、TreeSet
  *
  *
  *      |----Map接口：双列集合，存储一对一对(key - value)数据
  *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
  *
  *三、Collection接口中方法：
  *
  *
  * @author: cgq
  * @date: 2021/4/14 11:16
  */

public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        // add(Object e):将元素e添加到集合中
        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        //size()：获取添加的元素的个数
//        System.out.println(coll.size());//4

        Collection coll1 = new ArrayList();
        //addAll(Collection coll1):将coll1中元素添加到当前集合中
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

//        System.out.println(coll.size());//6
//        System.out.println(coll);//打印集合元素

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }

}
