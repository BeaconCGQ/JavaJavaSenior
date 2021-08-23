package com.atguigu.java2;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test1(){

        /**
         *
         * 1.向TreeSet添加数据要求是：相同类的对象
         * 2.两种排序方式：自然排序（实现comparable接口）、定制排序
         * 3.自然排序比较两个对象是否相等，标准为:compareTo()返回0，不再是equals()
         * 4.定制排序比较两个对象是否相等，标准为:compare()返回0，不再是equals()
         */
        TreeSet Set = new TreeSet();

//        Set.add(123);
//        Set.add(456);
//        Set.add("AA");
//        Set.add(new User("Tom",24)); //不能添加不同类对象

        //举例一：
//        Set.add(34);
//        Set.add(-34);
//        Set.add(54);
//        Set.add(0);

        //举例二：
        Set.add(new User("Tom",24));
        Set.add(new User("Jerry",34));
        Set.add(new User("Jim",14));
        Set.add(new User("Mike",20));
        Set.add(new User("Jack",30));
        Set.add(new User("Jack",23));

        Iterator iterator = Set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//遍历顺序是从小到大
        }


    }

    @Test
    public void test2(){

        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof  User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };
        TreeSet Set = new TreeSet(com);
        Set.add(new User("Tom",24));
        Set.add(new User("Jerry",34));
        Set.add(new User("Jim",14));
        Set.add(new User("Mike",20));
        Set.add(new User("Jack",30));
        Set.add(new User("Jack",14));//年龄先来后抛弃，不出现重复年龄

        Iterator iterator = Set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}
