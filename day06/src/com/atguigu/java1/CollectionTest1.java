package com.atguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
  *Collection接口声明方法使用：
  *
 *  像Collection接口实现类的对象中添加数据obj时，要求obj所在类重写equals()
  *
  * @author: 86173
  * @date: 2021/4/15 8:49
  */
public class CollectionTest1 {
    @Test
    public void test1(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //1.contains(Object obj):判断集合是否包含obj
        //(调用对象所在类的equals()进行比较)
        boolean contains = coll.contains(123);
        System.out.println(contains);//true
        System.out.println(coll.contains(new String("Tom")));//true
        System.out.println(coll.contains(new Person("Jerry",20)));//true

        //2.containsAll(Collection coll1):判断形参coll1中所有元素是否都存在于当前集合
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));//true

    }

    @Test
    public void test2(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //3.remove():从当前集合删除obj元素
        coll.remove(1234);
//        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
//        System.out.println(coll);

        //4.removeAll(Collection coll1): 从当前集合移除coll1中元素

        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);//移除共有元素123
//        System.out.println(coll);

    }

    @Test
    public void test3(){

        ArrayList coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //5.retainAll(coll1) :求两个集合交集，并且修改当前集合(coll)为共有元素
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println(coll);

        //6.equals(Object obj):比较当前集合和形参元素是否相等,顺序也必须一致
        Collection coll2 = Arrays.asList(123,456,new String("Tom"),false,new Person("Jerry",20));
        System.out.println(coll.equals(coll2));//true

    }

    @Test
    public void test4(){

        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("Jerry",20));

        //7.hashCode():返回哈希值
        System.out.println(coll.hashCode());

        //8.集合 ---> 数组： toArray():
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //数组 ---> 集合: 调用Arrays类的静态方法asList()
        List list = Arrays.asList(new String[]{"AA", "BB", "DD"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1，认为数组整体数一个元素
        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2

        //9. iterator():返回Iterator接口实例：用于遍历集合元素，放在IteratorTest.java测试
    }


}
