package com.atguigu.java1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
  *
  * |----Collection接口：单列集合，存储一个一个的对象
  *             |----List接口：存储有序、可重复数据    --->“动态数组”
  *                  |----ArrayList：作为List接口主要实现类，线程不安全，效率高，底层使用Object[] elementData 存储
  *                  |----LinkedList：对于频繁插入、删除操作，使用此效率高，底层使用双向链表存储
  *                  |----Vector： 作为List古老实现类，线程安全、效率低，底层使用Object[] elementData 存储
  *
  *  面试题：ArrayList、LinkedList、Vector三种异同？
  *  同：实现List接口，存储数据特点相同(有序、可重复)
  *  异：
  *
  *    1.ArrayList源码分析：
  *      jdk 7：
  *       ArrayList list = new  ArrayList(); //底层创建了长度为10的Object[]数组elementData
  *       list.add(11);//若添加时默认数组长度不够，则新建数组扩容为原来的1.5倍，将旧数组元素copy到新数组中
  *       结论：建议开发种，使用带参构造器，ArrayList list = new  ArrayList(Capacity);
  *      jdk 8：
  *       ArrayList list = new  ArrayList();//底层Object[] elementData初始化为{},并没有创建长度为10的数组
  *       list.add(123);//此时才创建长度为10的数组，并添加数据
  *      结：jdk7对象创建类似于单例模式饿汉式，jdk8类似于懒汉式，节省内存
  *
  *     2.LinkedList源码分析：
  *     LinkedList list = new LinkedList();//内部声明了Node类型的first和last属性，默认值为null；
  *     last.add(123);//将123封装到Node中，创建了Node对象
  *     private static class Node<E> {//双向列表
  *         E item;
  *         Node<E> next;
  *         Node<E> prev;
  *
  *         Node(Node<E> prev, E element, Node<E> next) {
  *             this.item = element;
  *             this.next = next;
  *             this.prev = prev;
  *         }
  *     }
  *
 * 3.List接口常用方法：
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素，并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
  *
  *
  *总结常用方法：
 *  增：add(Object obj)
 *  删：remove(int index) / remove(Object obj)
 *  改：set(int index, Object ele):
 *  查：get(int index)
 *  插：add(int index, Object ele)
 *  长度:size()
 *  遍历: ①Iterator迭代器 ②增强for循环 ③：普通循环
  *
  * @author: 86173
  * @date: 2021/4/15 14:57
  */
public class ListTest {

    @Test
    public void test3(){

        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom",12));
        list.add(456);

        //1.Iterator迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("*****************");
        //2.foreach
        for(Object obj : list){
            System.out.println(obj);
        }
        System.out.println("*****************");

        //普通for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

  @Test
  public void test1() {

      ArrayList list = new ArrayList();
      list.add(123);
      list.add(456);
      list.add("AA");
      list.add(new Person("Tom",12));
      list.add(456);

//      System.out.println(list);

      //void add(int index, Object ele):
      list.add(1,"BB");
//      System.out.println(list);

      //boolean addAll(int index, Collection eles):
      List list1 = Arrays.asList(1,2,3);
      list.addAll(list1);
      list.add(list1);//将整体视为一个元素
//      System.out.println(list);
//      System.out.println(list.size());//9

//      Object get(int index):
      System.out.println(list.get(1));

  }
  @Test
    public void test2(){

      ArrayList list = new ArrayList();
      list.add(123);
      list.add(456);
      list.add("AA");
      list.add(new Person("Tom",12));
      list.add(456);
      //int indexOf(Object obj):
      int index = list.indexOf(4567);
      System.out.println(index);//-1

      //int lastIndexOf(Object obj):
      System.out.println(list.lastIndexOf(456));

      //Object remove(int index):
      Object obj = list.remove(0);
//      System.out.println(obj);

     // Object set(int index, Object ele):
      list.set(1,"CC");
//      System.out.println(list);

      //List subList(int fromIndex, int toIndex):
      List list1 = list.subList(2, 4);
      System.out.println(list1);
      System.out.println(list);
  }
}
