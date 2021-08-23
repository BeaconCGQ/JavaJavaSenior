package com.atguigu.java1;

import org.junit.Test;

/**
 * 关于StringBuffer和 StringBuilder的使用：
 *
 * @author: 86173
 * @date: 2021/4/12 13:06
 */
public class StringBufferBuilderTest {

    /**
     * String、StringBuffer、StringBuilder三者异同？
     * String :不可变字符序列  使用char[]数组存储
     * StringBuffer : 可变字符序列 ：线程安全：效率低
     * StringBuilder : 可变字符序列 :线程不安全：效率高(jdk5.0新增)
     * <p>
     * 源码分析：
     * String str = new String();//new char[]
     * String str1 = new String(); //new char[]{'a','b','c'};
     * <p>
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16] 底层创建了长度16的数组
     * sb1.append('a');//value[0] = 'a';
     * sb1.append('b');//value[1] = 'b';
     * <p>
     * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16]
     * <p>
     * //问题一：System.out.println(sb2.length());  //
     * //问题二：扩容底层数组：默认扩容为原有容量的2倍加2；同时将原有数组复制到新数组中
     * <p>
     * 开发中，避免扩容，建议使用StringBuffer(int capacity),直接指定容量
     */
    @Test
    public void test1() {

        StringBuffer sb1 = new StringBuffer(("abc"));
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());  //0

    }

    /**
     * StringBuffer常用方法：
     * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
     * StringBuffer delete(int start,int end)：删除指定位置的内容
     * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * StringBuffer reverse() ：把当前字符序列逆转
     * <p>
     * public int indexOf(String str)
     * public String substring(int start,int end):返回(左闭右开)子字符串
     * public int length()
     * public char charAt(int n )
     * public void setCharAt(int n ,char ch)
     *
     *
     * 总结：
     * 增：append(xxx);
     * 删：delete(int start,int end):
     * 改：setCharAt(int n , char ch) /  replace(int start, int end, String str)
     * 查：charAt(int n)
     * 插：insert(int offset,xxx)
     * 长度：Length();
     * 遍历：for() + charAt() / toString()
     */


    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1); //abc11

        s1.delete(2, 4); //ab1
        System.out.println(s1);
        System.out.println(s1.replace(2, 4, "Hello"));//abHello
        s1.insert(2,false); // abfalseHello
        System.out.println(s1);
        System.out.println(s1.length());  //12
        System.out.println(s1.reverse());

        String s2 = s1.substring(1, 3);
        System.out.println(s2);


    }

    //效率对比:
    //StringBuilder > StringBuffer > String

    @Test
    public void teat3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
//开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i; }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }
}
