package exer3;

import java.util.Scanner;

/**
  * 编写一个Java应用程序，从键盘读取用户输入两个字符串，并重载3个函数分别实现这两个字符串的拼接、整数相加和浮点数相加。
  *  要进行异常处理，对输入的不符合要求的字符串提示给用户，不能使程序崩溃。
  * @author: 86173
  * @date: 2021/4/22 20:37
  */
public class String2 {
     public static void main(String[] args) {

         String2 user = new String2();
         Scanner scan = new Scanner(System.in);
         System.out.println("请输入两个字符串");
         String s1 = null;
         String s2 = null;
         try {
             s1 = scan.next();
             s2 = scan.next();
         } catch (Exception e) {
             e.printStackTrace();
         }

         int m1 = Integer.parseInt(s1);
         int m2 = Integer.parseInt(s2);
         double d1 = Double.parseDouble(s1);
         double d2 = Double.parseDouble(s2);

         String s3 = user.add(s1, s2);
         String s4 = user.add(m1, m2);
         String s5 = user.add(d1, d2);

         System.out.println(s3);
         System.out.println(s4);
         System.out.println(s5);



     }

     public String add(String s1,String s2){

         return s1 + s2;
     }
     public String add(int m,int n){

         return String.valueOf(m + n);
     }
     public String add(double m,double n){

         return String.valueOf(m + n);
     }
}

