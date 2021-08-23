package com.atguigu.java1;

import org.junit.Test;

import java.util.*;

/**
  *  添加、删除、修改操作：
 *   Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
  *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
  *  void clear()：清空当前map中的所有数据
  *
  *  元素查询的操作：
  *  Object get(Object key)：获取指定key对应的value
  *  boolean containsKey(Object key)：是否包含指定的key
  *  boolean containsValue(Object value)：是否包含指定的value
  *  int size()：返回map中key-value对的个数
  *  boolean isEmpty()：判断当前map是否为空
  *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
  *
  *  元视图操作的方法：
  *  Set keySet()：返回所有key构成的Set集合
  *  Collection values()：返回所有value构成的Collection集合
  *  Set entrySet()：返回所有key-value对构成的Set集合
  *
 *  总结：
 *  增:  put(Object key,Object value)
 *  删:  remove(Object key)
 *  改:  put(Object key,Object value)
 *  查:  get(Object key)
 *  长度:size()
 *  遍历:Set keySet() / Collection values() / Set entrySet()
 *
 *
  *
  * @author: 86173
  * @date: 2021/4/18 10:02
  */
public class MapMethodTest {
    /*
      元视图操作的方法：
  *  Set keySet()：返回所有key构成的Set集合
  *  Collection values()：返回所有value构成的Collection集合
  *  Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test3(){

        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",45);

        //遍历所有key集：KeySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        System.out.println("******************");

        //遍历所有key-value：entrySet()
        //方式一：
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            //entrySet集合中元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        System.out.println("*******************");
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = set.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "--->" + value);

        }



    }

    /*
     元素查询的操作：
  *  Object get(Object key)：获取指定key对应的value
  *  boolean containsKey(Object key)：是否包含指定的key
  *  boolean containsValue(Object value)：是否包含指定的value
  *  int size()：返回map中key-value对的个数
  *  boolean isEmpty()：判断当前map是否为空
  *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test2(){

        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",45);

        //Object get(Object key)
        System.out.println(map.get(45));

        // boolean containsKey(Object key)
        boolean isExit = map.containsKey("BB");
        System.out.println(isExit);
        //boolean containsValue(Object value)
        boolean isExit1 = map.containsValue(123);
        System.out.println(isExit1);

        //int size()
        //boolean isEmpty()
        map.clear();
        boolean empty = map.isEmpty();
        System.out.println(empty);//true

        //boolean equals(Object obj)

    }

    /*
     添加、删除、修改操作：
  *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
  *  void putAll(Map m):将m中的所有key-value对存放到当前map中
      Object remove(Object key)：移除指定key的key-value对，并返回value
  *  void clear()：清空当前map中的所有数据
     */
    @Test
    public void test1(){

        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",45);
        map.put("AA",87);//修改

//        System.out.println(map);//AA只有一个，进行value替换

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        map.putAll(map1);
//        System.out.println(map);

        //remove(Object key)
        Object value = map.remove("CC");
        System.out.println(value);
        System.out.println(map);

        map.clear();//与map = null 不同
        System.out.println(map.size());
        System.out.println(map);// {}

    }


}
