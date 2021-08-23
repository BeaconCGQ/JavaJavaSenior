package com.atguigu.java1;

import org.junit.Test;

import java.util.*;

/**
  *
  * @author: 86173
  * @date: 2021/4/18 10:37
  */
public class TreeMapTest {

    //向TreeMap中添加key-value：要求key必须是由同一个类创建的对象
     //因为是按照key进行排序：自然排序、定制排序

     @Test
    public void test1(){

         TreeMap map = new TreeMap();
         User u1 = new User("Tom",23);
         User u2 = new User("Jerry",34);
         User u3 = new User("Jack",54);
         User u4 = new User("Rose",29);

         map.put(u1,98);
         map.put(u2,89);
         map.put(u3,76);
         map.put(u4,100);

         Set entrySet = map.entrySet();
         Iterator iterator1 = entrySet.iterator();
         while(iterator1.hasNext()){
             Object obj = iterator1.next();
             Map.Entry entry = (Map.Entry) obj;
             System.out.println(entry.getKey() + "--->" + entry.getValue());
         }
     }

     @Test
    public void test2(){

         TreeMap map = new TreeMap(new Comparator() {
             @Override
             public int compare(Object o1, Object o2) {
                 if(o1 instanceof User && o2 instanceof User){
                     User u1 = (User) o1;
                     User u2 = (User) o2;
                     return Integer.compare(u1.getAge(),u2.getAge());
                 }
                 throw new RuntimeException("输入类型不匹配");
             }
         });

         User u1 = new User("Tom",23);
         User u2 = new User("Jerry",34);
         User u3 = new User("Jack",54);
         User u4 = new User("Rose",29);

         map.put(u1,98);
         map.put(u2,89);
         map.put(u3,76);
         map.put(u4,100);

         Set entrySet = map.entrySet();
         Iterator iterator1 = entrySet.iterator();
         while(iterator1.hasNext()){
             Object obj = iterator1.next();
             Map.Entry entry = (Map.Entry) obj;
             System.out.println(entry.getKey() + "--->" + entry.getValue());
         }

     }


}
