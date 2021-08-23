package exer6;

import org.junit.Test;

import java.util.*;

/**
 * 定义一个Map接口类型的变量，引用一个实现类，添加键值对，
 * 判断集合中是否包含某一key值，通过某一key值得到value值，
 * 通过某一key删除键值对，把另一个map集合添加到此map集合，判断是否为空，
 * 清除集合，返回集合里元素的个数等常用操作。
 *
 * @author: 86173
 * @date: 2021/4/23 21:46
 */
public class MapTest {
    @Test
    public void test1(){

        Map map = new HashMap();
        map.put("cgq",12);
        map.put("html",23);
        map.put("css",54);

        System.out.println(map.containsKey("cgq"));
        System.out.println(map.get("html"));
        System.out.println(map.remove("css"));

        Map map1 = new HashMap();
        map1.put("lxl",34);

        map.putAll(map1);
        System.out.println(map);

        System.out.println(map.isEmpty());
        System.out.println(map.size());
//        map.clear();
        System.out.println(map.isEmpty());

        System.out.println("*********");

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry)obj;
            System.out.print(entry.getKey() + ":" + entry.getValue()+ "\n");
        }

        System.out.println("**********************");
        Set set1 = map.entrySet();
        for(Object obj : set1){
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
    @Test
    public void test2(){

        Integer[] datas = {1,2,3,4,5};
        List<Integer> list = Arrays.asList(datas);
        list.add(5);//报错，ArrayList继承于AbstractList

    }
}
