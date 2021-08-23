package com.atguigu.java;

/**
  * 例子：创建三个窗口卖票，总票数100张，使用Runnable接口方式
  *
  *
  *
  * @author: 86173
  * @date: 2021/4/10 13:17
  */

 class window1 implements  Runnable{

     private int ticket = 100;

     @Override
     public void run() {
         while(true){
             if (ticket > 0){
                 System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                 ticket--;
             }else{
                 break;
             }
         }

     }
 }


public class windowTest1 {
    public static void main(String[] args) {

        window1 w1 = new window1();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }

}
