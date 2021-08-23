package com.atguigu.java3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
  * 1.泛型在继承方面的体现：
 *
 *   类A时类B的父类 ，但G<A> 和 G<B> 不具备子父类关系,二者是并列关系
 *    补充：类A是类B的父类 ，则A<G> 是 B<G> 的父类
  *
  *
  * 2.通配符的使用：
  *
  * @author: 86173
  * @date: 2021/4/19 10:25
  */
public class GenericTest {
    /*
      1.泛型在继承方面的体现：

     */
    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;

        List<Object> list1 = null;
        List<String> list2 = null;
//        list1= list2; //编译错误，此时list1和list2不具备子父类关系

        /*
        反证法：
        假设list1 = list2;
        list1.add(123); 导致list2混入非String类型数据

         */
    }
    @Test
    public void test2(){

        List<String> list1 = null;
        ArrayList<String> list2 = null;
        list1 = list2;

    }

    @Test
    public void test3(){

        /*
        通配符：?

        类A是类B的父类，G<A> 和 G<B>没有挂心，二者共同父类：G<?>
         */
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;

        list = list1;
        list = list2;

//        show(list1); //编译通过
//        show(list2);

        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("DD");
        list = list3;
        //添加：list<?> 不能添加数据
        //可以添加 null
//        list.add("DD");
        list.add(null);

        //获取：允许读取数据，类型为Object
        Object o = list.get(0);
        System.out.println(o);

    }

    /**
     * 3.有限制条件的通配符
     *   ? extends A : 限制为A或A的子类
     *    ? super A:  限制为A或A的父类
     *
     */
    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<>();
        List<Person>  list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据
        list1 = list3;
        Person person = list1.get(0);
//        Student s = list1.get(0); //编译错误

        list2 = list4;
        Object obj = list2.get(0);

        //写数据
//        list1.add(new Student());  编译不通过
        list2.add(new Person());
        list2.add(new Student());//能装Person必能装其子类Student


    }

    public void show(List<?> list){

        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
