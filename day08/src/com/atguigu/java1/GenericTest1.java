package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
  * 自定义泛型结构：泛型类、泛型接口；泛型方法：
  *
  * 1.自定义泛型类、泛型接口：
 *
 *  2.泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系，
 *             泛型方法所属的类是不是泛型类都没有关系
 *             泛型方法可以声明为静态，原因：泛型参数是在调用方法时确定的，并非实例化时确定
  *
  * @author: 86173
  * @date: 2021/4/18 15:30
  */
public class GenericTest1 {
    @Test
    public void test1(){

        Order order = new Order();
        //若定义泛型类，实例化没有指明泛型，则认为此泛型类型为Object类型
        //要求：若定义了泛型类，建议实例化使用泛型
        order.setOrderT(123);
        order.setOrderT("abc");

        //使用泛型：
        Order<String> order1 = new Order<String>("orderAA","1001","order:AA");
        order1.setOrderT("AA:hello");

    }
    @Test
    public void test2(){

        //子类继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型
        SubOrder sub = new SubOrder();
        sub.setOrderT(1122);

        SubOrder1<String> sub1 = new SubOrder1<>();
        sub1.setOrderT("order2---");

    }
    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2= null;
//        list1 = list2; //不能赋值

    }

    @Test
    public void test4(){

        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.arrayCopyToLst(arr);

        System.out.println(list);

    }
}
