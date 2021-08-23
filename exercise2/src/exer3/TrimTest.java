package exer3;

import org.junit.Test;

/**
  * 模拟一个trim方法，去除字符串两端的空格
 *
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
  *
  * @author: 86173
  * @date: 2021/4/22 20:59
  */
public class TrimTest {
    @Test
    public void test1(){

        String str = new String("  sda dsf sa  ");
        int start = 0;
        int end = str.length();
        while( start < end && str.charAt(start) == ' '){
            start++;
        }
        while(start < end && str.charAt(end-1) == ' '){
            end--;
        }

        System.out.println("--" + str.substring(start,end) + "--");
    }

    //方式一：
    public String Reverse(String str,int start,int end){

        String str2 = str.substring(0,start-1);
        String str3 = str.substring(end);
        String str1 = str.substring(start-1,end);

        char[] ch = new char[str1.length()];
        for(int i = end - start ;i >= 0; i--){
            ch[end - start -i] = str1.charAt(i);
        }
        return str2 + new String(ch) + str3;


    }
    //方式二：
    public static String reverseString1(String str,int start,int end){
        String str1 = str.substring(0, start);
        for(int i = end;i >= start;i--){
            char c = str.charAt(i);
            str1 += c;
        }

        str1 += str.substring(end + 1);
        return str1;
    }
    //方式三：
    public static String reverseString(String str,int start,int end){
        char[] c = str.toCharArray();//字符串--->字符数组
        return reverseArray(c,start,end);

    }
    public static String reverseArray(char[] c,int start,int end){
        for(int i = start,j = end;i < j;i++,j--){
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        //字符数组--->字符串
        return new String(c);
    }
    @Test
    public void test2(){

        String str = "abcdefg";
        String reverse = Reverse(str, 2, 5);
        System.out.println(reverse);


    }
}
