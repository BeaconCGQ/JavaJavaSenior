package com.atguigu.java;

import org.junit.Test;

/**
 *  boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 *  boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 *  boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
 * <p>
 *  boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
 *  int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 *  int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
 *  int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 *  int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
 * <p>
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
 * <p>
 *  String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 *  String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 *  String replaceAll(String regex, String replacement) ：使用给定的replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 *  String replaceFirst(String regex, String replacement) ：使用给定的replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 * <p>
 *  boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
 *  String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
 *  String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 *
 * @author: 86173
 * @date: 2021/4/11 16:40
 */
public class StringMethodTest2 {

    @Test
    public void test2() {

        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace("北", "东");
        System.out.println(str1);//不变
        System.out.println(str2);//东京尚硅谷教育东京

        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);



    }

    @Test
    public void test1() {

        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3);

        System.out.println("************");

        String str2 = "wo";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lo"));//3
        System.out.println(str1.indexOf("wof"));//-1

        System.out.println(str1.indexOf("lo", 5));//-1

        System.out.println("*******************");

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));//7
        System.out.println(str3.lastIndexOf("or", 6));//4


    }
}
