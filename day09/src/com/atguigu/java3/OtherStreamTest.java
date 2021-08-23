package com.atguigu.java3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
  * 其他流使用：
  *
  * 1.标准输入输出流：System.out和 System.in
  * 2.打印流：PrintStream 和 PrintWriter
  * 3.数据流：DataInputStream 和 DataOutputStream （用于读取或写出基本数据类型的字符串或变量，读取顺序与写入顺序一致)
  *
  * @description:
  * @author: 86173
  * @date: 2021/4/21 21:39
  */
public class OtherStreamTest {
    /*
    1.标准输入输出流
    System.in:标准输入流，默认键盘输入
    System.out：标准输出流，默认控制台输出
    2.
    System类的setIn() / setOut() 重新指定输入输出的流
     */
    public static void main(String[] args) throws IOException {


         //从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
         //进行输入操作，直至当输入“e”或者“exit”时，退出程序。
         //方法一：使用Scanner实现
         //方法二：System.in -->转换流 ---> BufferedReader的readLine()

         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader br = new BufferedReader(isr);

         while(true){
             System.out.println("输入字符串：");
             String data = br.readLine();
             if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                 System.out.println("程序结束");
                 break;
             }
             String s = data.toUpperCase();
             System.out.println(s);
         }

         br.close();
     }
     /*
       打印流：PrintStream 和 PrintWriter

      */

}
