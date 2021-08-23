package com.atguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
  * 集合元素的遍历：使用Iterator接口
  *
 *   方法：next() 和 hasNext()
  *
 * 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 *
 * remove():删除元素，不同于集合直接调用remove()，这是在迭代器中调用
  *
  * @author: 86173
  * @date: 2021/4/15 10:07
  */
public class IteratorTest {
    @Test
    public void test1(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());//只输入一个元素
        //方式一：
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//
//        }

        //方式二：推荐
        while(iterator.hasNext()){
            //next(): ①指针下移 ②将下移以后集合位置上元素返回
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //remove():移除元素
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
