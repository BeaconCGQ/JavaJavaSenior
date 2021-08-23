package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
  *1.Set接口框架：
  * |----Collection接口：单列集合，存储一个一个的对象
  *    |----Set接口：存储无序、不可重复数据   --->高中数学的集合
  *            |----HashSet：作为Set接口的主要实现类，线程不安全，可以存储null值
  *                |----LinkedHashSet：HasSet子类,遍历其内部数据时，可以按照添加顺序遍历
  *            |----TreeSet：按照添加对象的指定属性进行排序
  *
  * 2.Set接口没有额外定义方法，使用的都是Collection接口中定义的
 *
 *   要求：向Set添加数据，其所在类要重写equals()和hashCode()方法
 *        重写的equals()和hashCode()尽可能保持一致性，相等的对象必须具有相等的散列码
 *       技巧：
 *
  * @author: 86173
  * @date: 2021/4/16 10:22
  */
public class SetTest {
    /**
     * 一、Set:存储无序、不可重复数据
     * 以HashSet说明：
     * 1.无序性：不等于随机性，存储数据在底层并非按照数组索引的顺序添加，而是根据数据的Hash值决定
     * <p>
     * 2.不可重复性：保证添加元素按照equals()判断时，不能返回true，即不能添加相同元素
     * <p>
     * 二、添加元素过程：HashSet为例
     * 我们向HashSet添加元素a，首先调用a所在类的HashCode()方法，计算元素a的hash值，此hash值接着通过某种算法计算出HashSet在底层数组存储位置
     * ，即为索引位置，判断数组此位置上是否有元素：
     * 若没有元素，则a添加成功 --- 情况1
     * 若已有元素b（或以链表形式存在的多个元素)，则比较a与b的hash值：
     * 若hash值不同，则元素a添加成功 --- 情况2
     * 若hash值相同，进而调用元素a所在类的equals()方法：
     * 若返回true，则元素a添加失败
     * 若返回false，则元素a添加成功   --- 情况3
     * 对于情况2/3，元素a与已经此索引位置上数据以链表形式存储
     * jdk 7 ：元素a放到数组中，指向原来元素
     * jdk 8 ：原来元素在数组种，指向元素a
     * 总结：七上八下（对新元素而言）
     * <p>
     * 故HashSet底层是 数组+链表;
     */
    @Test
    public void test1() {

        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add(new Person("Tom", 23));
        set.add(new Person("Tom", 23));
        set.add("DD");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet使用：
    //作为HashSet子类，在添加数据同时，每个数据还维护两个引用，记录此数据前后数据
    //对于频繁遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add(123);
        set.add("AA");
        set.add(new Person("Tom", 23));
        set.add(new Person("Tom", 23));
        set.add("DD");

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}