package com.atguigu.java1;

import java.util.ArrayList;
import java.util.List;

/**
  * 自定义泛型类：
  *
  * @author: 86173
  * @date: 2021/4/18 15:29
  */
public class Order<T> {

    String orderName;
    String orderId;

    //类的内部结构可以使用类的泛型

    T orderT;

    public Order(){
        //编译错误
//        T[] arr = new T[10];
        //编译正确
        T[] arr = (T[]) new Object[10];

    };

    public Order(String orderName,String orderId,T orderT){
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderT = orderT;
    }

    //如下三个方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderT=" + orderT +
                '}';
    }
//静态方法中不能使用类的泛型。
//    public static void show(){
//
//        System.out.println(orderT);
//    }

    //泛型方法
     public <E> List<E> arrayCopyToLst(E[] arr){

         ArrayList<E> list = new ArrayList<>();
         for(E e : arr){
             list.add(e);
         }
        return list;
     }
}
