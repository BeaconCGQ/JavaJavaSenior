package com.atguigu.java;


/**
 * 例子：创建三个窗口卖票，总票数100张，继承Thread类的方式
 *
 *
 *
 *
 * @author: 86173
 * @date: 2021/4/10 12:43
 */

class  window2 extends  Thread{

    private static int ticket = 100;

    private static Object obj  = new Object();
    @Override
    public void run() {

        while(true){
//            synchronized (this){  错误，对象不唯一
//            synchronized (obj) {  正确
              synchronized (window2.class){//类也是对象，且类只会加载一次
                if (ticket > 0) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class windowTest2 {
    public static void main(String[] args) {

        window2 w1 = new window2();
        window2 w2 = new window2();
        window2 w3 = new window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}