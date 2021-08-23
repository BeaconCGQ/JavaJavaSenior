package com.atguigu.java;

/**
  * 例子：创建三个窗口卖票，总票数100张，继承Thread类的方式
  *
  *  存在线程安全问题
  *
  *
  * @author: 86173
  * @date: 2021/4/10 12:43
  */

 class  window extends  Thread{

     private static int ticket = 100;

     @Override
     public void run() {

         while(true){
             if (ticket > 0){
                 System.out.println(getName() + ":卖票，票号为：" + ticket);
                 ticket--;
             }else{
                 break;
             }
         }
     }
 }


public class WindowTest {
    public static void main(String[] args) {

        window w1 = new window();
        window w2 = new window();
        window w3 = new window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
