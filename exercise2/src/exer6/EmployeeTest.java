package exer6;

import java.util.*;

/**
  * 使用Map接口的实现类完成员工工资(姓名--工资)的摸拟：
  * 1)添加几条信息
  * 2)列出所有的员工姓名
  * 3列出所有员工姓名及其工资
  * 4)删除名叫“Tom”的员工信息
  * 5)输出Jack的工资，并将其工资加1000元(通过取值实现)
  * 6)将所有工资低于1000元的员工的工资上涨20%(通过取值实现)
  * 创建有序的map集合的实例化对象，添加元素，查看排序结果
  * @author: 86173
  * @date: 2021/4/24 19:35
  */
public class EmployeeTest {
     public static void main(String[] args) {

         Map<String,Integer> map = new HashMap<>();
         map.put("Jack",6000);
         map.put("Tom",5000);
         map.put("Jerry",8000);
         map.put("Ming",4000);

         Set<String> name = map.keySet();
         for(String s : name){
//             System.out.println(s);
         }

         Set<Map.Entry<String, Integer>> entries = map.entrySet();
         Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
         while(iterator.hasNext()){
             Map.Entry<String, Integer> emp = iterator.next();
             System.out.println(emp.getKey() + ": " + emp.getValue() );
         }
         System.out.println(map.remove("Tom"));

         System.out.println((map.get("Jack") + 1000));

         TreeMap map1 = new TreeMap();
         map1.put("Jack",6000);
         map1.put("Tom",5000);
         map1.put("Jerry",8000);
         map1.put("Ming",4000);
         Set set = map1.entrySet();

         Iterator iterator1 = set.iterator();
         while(iterator1.hasNext()){
             Map.Entry next =(Map.Entry) iterator1.next();
             System.out.println(next.getKey() + ":" + next.getValue());
         }
     }
}


