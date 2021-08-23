package exer5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
  *
  *定义一个Collection接口类型的变量，引用一个List集合的实现类，实现添加单个元素，
  * 添加另一个集合，删除元素，判断集合中是否包含一个元素，判断是否为空，清除集合，
  *  返回集合里元素的个数等常用操作。
  *
  * @author: 86173
  * @date: 2021/4/23 20:45
  */
public class ListTest {
    @Test
    public void test1(){

        Collection coll = new ArrayList();
        coll.add("cgq");

        Collection coll1 = Arrays.asList("Jack",23,"html");

        coll.addAll(coll1);
        System.out.println(coll);

        coll.remove("html");
        System.out.println(coll);

        System.out.println(coll.contains("cgq"));
        System.out.println(coll.size());
        coll.clear();
        System.out.println(coll.isEmpty());
    }
    /*
    创建ArrayList实例化对象，添加10个以上的元素，在2号位插入一个元素，获得5号位元素，删除6号位元素，修改7号位的元素；
     */
    @Test
    public void test2(){

        ArrayList list = new ArrayList();
        list.add("cgq");
        list.add("html");
        list.add(12);
        list.add("chen");
        list.add(35);
        list.add(89);
        list.add("css");
//        System.out.println(list);

        list.add(1,"chenGuoQing");
//        System.out.println(list);

        System.out.println(list.get(4));
        list.remove(5);
//        System.out.println(list);
        list.set(6,"ck");
//        System.out.println(list);

        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {

//            System.out.print(iterator.next() + " , ");
//        }

//        for(Object obj : list){
//            System.out.print(obj + " ");
//        }
//
//        for(int i = 0;i < list.size(); i++){
//            System.out.println(list.get(i));
//        }

        System.out.println(list);

    }
}
