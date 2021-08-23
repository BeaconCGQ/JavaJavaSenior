package com.atguigu.java;

/**
 * 使用同步方法解决继承Thread类的线程安全问题
 *
 * @author: 86173
 * @date: 2021/4/10 16:25
 */

class window4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {

            show();
        }

    }

    private static synchronized void show() {//同步监视器：当前类 window4.class
//    private synchronized void show() {//同步监视器：t1 t2 t3
        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class windowTest4 {
    public static void main(String[] args) {

        window4 w1 = new window4();
        window4 w2 = new window4();
        window4 w3 = new window4();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}