package com.atguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
  *
  * jdk5.0新增 foreach循环，用于遍历集合、数组
  *
  *
  * @author: 86173
  * @date: 2021/4/15 10:34
  */
public class ForTest {
    @Test
    public void test1(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //for(集合元素类型 局部变量 : 集合对象){}
        //内部仍然调用了迭代器
        for(Object obj: coll){
            System.out.println(obj);
        }

    }
    @Test
    public void test2(){

        int arr[]  = new int[]{1,2,3,4,5};
        for(int i : arr){
            System.out.println(i);
        }

    }

    //练习题
    @Test
    public void test3(){

        String[] arr = new String[]{"AA","BB","DD"};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//
//        }
        for (String s : arr){
            s = "GG";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
