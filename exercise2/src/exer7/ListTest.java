package exer7;

import org.junit.Test;

import java.util.*;

/**
  * @description:
  * @author: 86173
  * @date: 2021/4/24 20:04
  */
public class ListTest {
    //创建一个List集合的对象，添加几个数字，反转对象中元素的顺序；根据元素的自然顺序排序；
     @Test
    public void test1(){

         List list = new ArrayList();
         list.add(10);
         list.add(5);
         list.add(7);
         list.add(-2);
         list.add(0);

         System.out.println(list);

//         Collections.reverse(list);
//         System.out.println(list);

         for(int i = list.size() - 1; i >= 0;i--){
             System.out.println(list.get(i));
         }

//         Collections.sort(list);
     }
//   要求集合对象c1中，只能添加字符串形式的单个元素，元素可以重复，在测试类中为c1集合添加字符串“这是一个可以重复的集合”三遍，然后遍历打印结果。
//2 ）要求集合对象c2中只能添加整型数值，并且不可重复，按自然顺序排序。要求遍历集合对象，打印添加进1,2,3,4,5五个数字的c2集合
//3 ）要求创建一个合适的Map集合对象m1，它的键和值都只能是字符串，并且值可以是null，像map集合中添加三组字符串，其中一个只有键，值是空，遍历这个集合对象的键，并打印键。
//4）想办法将m1中所有值为null都替换成一个字符串”这里是空值”
//5）遍历m1的所有值。
     @Test
    public void test2(){

         ArrayList<String> list1 = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
             list1.add("这是一个可以重复的集合");
         }
//         System.out.println(list1);

         Set<Integer> set1 = new HashSet<>();
         for (int i = 1; i <=5; i++) {
             set1.add(i);
         }

         Map<String,String> map1 = new HashMap<>();
         map1.put("sd",null);
         map1.put("as","ds");
         map1.put(null,null);
         System.out.println(map1);

         Set<Map.Entry<String, String>> entry = map1.entrySet();

         Iterator<Map.Entry<String, String>> iterator = entry.iterator();
         while(iterator.hasNext()){
             Map.Entry<String, String> e = iterator.next();
             if(e.getValue() == null){
                 e.setValue("这里是空值");
             }
             System.out.println(e.getKey() + " :" + e.getValue());

         }
     }
}
