package com.atguigu.java1;

import org.junit.Test;

import java.util.*;

/**
  * 泛型的使用：
  * 1.jdk5.0新增
  *
 *  2.集合使用泛型总结：
 *    ① 集合接口或集合类jdk5.0时都修改为带泛型的结构
 *    ② 在实例化集合类时，可以指明具体的泛型类型
 *    ③ 在集合类或接口中，凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型
 *        比如：add(E e)  --->实例化后： add(Integer e)
 *    ④ 泛型类型必须是类，不能是基本数据类型，用包装类代替
 *    ⑤ 如果实例化时，没有指明泛型类型，默认为java.lang.Object类型
 *
 *  3.自定义泛型结构：泛型类、泛型接口；泛型方法. 见GenericTest1
 *
 *
 *
  *
  * @author: 86173
  * @date: 2021/4/18 14:10
  */
public class GenericTest {
    //集合中使用泛型之前：
    @Test
     public void test1(){

        ArrayList list = new ArrayList();
        list.add(78);
        list.add(98);
        list.add(76);
        list.add(60);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时可能出现类型转换异常ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }

    }
    //集合中使用泛型:
    @Test
    public void test2(){

        ArrayList<Integer> list = new ArrayList<Integer>();
//        ArrayList<Integer> list1 = new ArrayList(); //jdk7可省略后面的类型

        list.add(78);
        list.add(98);
        list.add(76);
        list.add(60);
//        list.add("t");  //编译错误，类型不匹配，保证数据安全
        for(Integer score: list){
            //无需强转
            int stuScore = score;
            System.out.print(stuScore + " ");
        }
        System.out.println("*****************");

        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.print(stuScore + " ");
        }

    }
    //HashMap使用泛型：
    @Test
    public void test3(){

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("Tom",87);
        map.put("Jerry",67);
        map.put("Jack",98);
//        map.put(123,"sto");//类型不匹配

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "-->" + value);
        }


    }

}
