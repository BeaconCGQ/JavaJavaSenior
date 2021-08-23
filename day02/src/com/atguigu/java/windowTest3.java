package com.atguigu.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 总结：
 *   1.仍然涉及到同步监视器，不需要显示声明
 *   2.非静态的同步方法，同步监视器是：this
 *     静态同步方法，同步监视器是：当前类本身
 *
 *
 * @author: 86173
 * @date: 2021/4/10 16:06
 */


class window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();
        }

    }

    public synchronized void show()  {//同步监视器：this
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


public class windowTest3 {
    public static void main(String[] args) {

        window3 w1 = new window3();

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
