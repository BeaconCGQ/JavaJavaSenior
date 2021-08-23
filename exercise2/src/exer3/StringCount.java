package exer3;

import org.junit.Test;

import java.util.Arrays;

/**
  * 获取一个字符串在另一个字符串中出现的次数。判断str2在str1中出现的次数\
 *
 * 对字符串进行自然排序
  * @author: 86173
  * @date: 2021/4/22 21:27
  */
public class StringCount {


    @Test
    public void test1(){

        int count = 0;
        int index = 0;
        String str1 = "helloworldhehesdhe";
        String str2 = "he";

        while(str1.indexOf(str2,index) >= 0) {
              count++;
              index = str1.indexOf(str2,index) + str2.length();

        }
        System.out.println(count);

    }
    @Test
    public void test2(){
        String str = "ksdhgskfas";
        char[] ch = str.toCharArray();

        Arrays.sort(ch);

        String s = new String(ch);
        System.out.println(s);

    }
    @Test
    public void test3(){
        String s = "people";
        String t = "people";
        String c[] = {"p","e","o","p","l","e"};

        System.out.println(t.equals(new String("person")));
        System.out.println(s.equals(t));
        System.out.println(t.equals(c));
        System.out.println(s == t);


    }



}
