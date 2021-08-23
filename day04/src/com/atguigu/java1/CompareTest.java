package com.atguigu.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、java对象正常情况进行比较： == != 不能使用 > <
 * 在开发中，需要对对象进行排序，需要比较对象大小
 * 使用接口：Comparable 、Comparator
 * <p>
 *
 * Comparable 、Comparator使用对比：
 *     Comparable接口方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 *     Comparator接口属于临时比较
 *
 * @author: 86173
 * @date: 2021/4/13 11:45
 */
public class CompareTest {
    @Test
    public void test1() {

        /*
        Comparable接口使用举例：自然排序
        1.String、包装类实现了Comparable接口，重写了compareTo(obj)方法，给出比较对象大小(从小到大排列)
        2.重写compareTo(obj)的规则:如果当前对象this大于形参对象obj，则返回正整数，
                                 如果当前对象this小于形参对象obj，则返回负整数，
                                 如果当前对象this等于形参对象obj，则返回零。
        3.自定义类实现排序：让其实现Comparable接口，重写compareTo(obj)方法
         */
        String[] arr = new String[]{"AA", "BB", "MM", "CC", "JJ", "DD"};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2() {

        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microMouse", 43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /*
    Comparator接口使用：定制排序
       1.背景：当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，那
              么可以考虑使用 Comparator 的对象来排序，
       2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返回正整数，则表示o1大于o2；如果返回0，表示相等；
                                                             返回负整数，表示o1小于o2


     */
    @Test
    public void test3(){

        String[] arr = new String[]{"AA", "BB", "MM", "CC", "JJ", "DD"};

        Arrays.sort(arr, new Comparator() {
            //按字符串从大到小顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){


        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microMouse", 43);
        arr[5] = new Goods("microMouse", 23);

        Arrays.sort(arr, new Comparator() {

            //产品名称从高到低,价格从高到低
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof  Goods){
                    Goods d1 = (Goods) o1;
                    Goods d2 = (Goods) o2;
                    if(d1.getName().equals(d2.getName())){
                        return -Double.compare(d1.getAge(),d2.getAge());
                    }else{
                        return d1.getName().compareTo(d2.getName());
                    }
                }throw new RuntimeException("输入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }


}
