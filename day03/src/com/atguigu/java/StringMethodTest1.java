package com.atguigu.java;

import org.junit.Test;

import java.util.Objects;

/**
 *  int length()：返回字符串的长度： return value.length
 *  char charAt(int index)： 返回某索引处的字符return value[index]
 *  boolean isEmpty()：判断是否是空字符串：return value.length == 0
 *  String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 *  String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 *  String trim()：返回字符串的副本，忽略前导空白和尾部空白
 *  boolean equals(Object obj)：比较字符串的内容是否相同
 *  boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写
 *  String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
 *  int compareTo(String anotherString)：比较两个字符串的大小
 *  String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。
 *  String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
 *
 * @author: 86173
 * @date: 2021/4/11 16:17
 */
public class StringMethodTest1 {

    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));//false
        System.out.println(s1.equalsIgnoreCase(s2));//true

        boolean equals = Objects.deepEquals(s1, s2);
        System.out.println(equals);

        String s3 = "abc";
        String s4 = new String("abe");
        System.out.println(s3.compareTo(s4));//涉及到字符串排序

        String s5 = "北京尚硅谷教育";
        String s6 = s5.substring(2);
        System.out.println(s6);
        String s7 = s5.substring(2, 5);
        System.out.println(s7);


    }

    @Test
    public void test1() {

        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));

        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);//不变
        System.out.println(s2);

        String s3 = s1.toUpperCase();
        System.out.println(s3);

        System.out.println("******************");

        String s4 = "  hel  lo wor ld   ";
        String s5 = s4.trim();
        System.out.println("---"+ s4 + "---");
        System.out.println("---"+ s5 + "---");

    }
}
