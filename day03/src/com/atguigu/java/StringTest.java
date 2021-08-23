package com.atguigu.java;

import org.junit.Test;

/**
 * String 的使用
 *
 * @author: 86173
 * @date: 2021/4/11 14:51
 */
public class StringTest {
    /*
       String:字符串，使用 "" 表示
       1.String声明为final的，不可被继承
       2.String实现了Serializable接口：表示字符串支持序列化
               实现了Comparable接口：表示String可以比较大小
       3.String内部定义了final char[] value 用于存储字符串数组
       4.String：代表不可变的字符序列
            体现：1.对字符串重新赋值，需要重新指定区域内赋值，不能使用原有value进行赋值
                 2.当对现有字符串进行连接操作时，也需要重新指定内存区域赋值
                 3.当调用String的replace()修改字符或字符串时，仍然需要重新指定区域内赋值

       5.通过字面量方式个字符串赋值，此时声明在字符串常量池中
       6.字符串常量池不会存储相同内容的字符串
     */
    @Test
    public void test1() {

        String s1 = "abc";//字面量定义
        String s2 = "abc";
//        s1 = "Hello";

        System.out.println(s1 == s2);//比较地址值(常量池不会存储相同的字符串，故s1和s2指向同一个字符串)

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("********************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);

        System.out.println("********************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');//仍然重新指定内存区域赋值
        System.out.println(s4);
        System.out.println(s5);
    }

    /*
        String的实例化方式：
        方式一：通过字面量定义
        方式二：通过new + 构造器

        面试题： String s = new String("abc");此方式在内存中创建了几个对象
                两个：堆空间new一个，char[]对应常量池中数据"abc"
     */
    @Test
    public void test2() {

        String s1 = "JavaEE";//声明在方法区的字符串常量池中
        String s2 = "JavaEE";
        //s3和s4保存的地址值，数据在堆空间开辟空间以后对应的地址值
        String s3 = new String("JavaEE");
        String s4 = new String("JavaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s3 == s4);//false
        System.out.println(s1 == s3);//false

        System.out.println("***********");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true  常量池中


    }

    /*
        1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量.只要其中有一个是变量，结果就在堆中
     */
    @Test
    public void test3() {

        String s1 = "JavaEE";
        String s2 = "hadoop";

        String s3 = "JavaEEhadoop";
        String s4 = "JavaEE" + "hadoop";

        String s5 = s1 + "hadoop";
        String s6 = "JavaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false

        String s8 = s5.intern();//返回值是使用在常量池中存在的
        System.out.println(s3 == s8);//true
    }
}
