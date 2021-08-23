package com.atguigu.java;

/**
 * 多线程的创建：方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()方法--> 将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()方法:①启动当前线程②调用当前线程的run()方法
 * <p>
 * 例子：遍历100以内所有偶数
 *
 * @author: 86173
 * @date: 2021/4/9 20:19
 */

class MyThread extends Thread {

    public void run() {

        for(int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":" +i);
            }
        }
    }

}

public class ThreadTest {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        //另一个线程中执行
        t1.start();
//        一、不能直接调用run()方法启动线程
//        t1.run();
//        二、再启动新线程就会抛异常，start()只能调用一次

//        三、多线程只能新创建一个对象去调用start()
        MyThread t2 = new MyThread();
        t2.start();

        //主线程main()中执行
        for(int i = 0; i < 100; i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":" +i + "*******");
            }
        }
    }
}
