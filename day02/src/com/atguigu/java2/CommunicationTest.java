package com.atguigu.java2;

/**
 * 线程通信的例子：使用两个线程打印 1-100。线程1, 线程2 交替打印
 *
 * 三个方法：
 * wait(): 一旦执行此方法，当前线程进入阻塞状态，并释放同步监视器
 * notify(): 一旦执行此方法，就会唤醒wait()的一个线程，如果多个线程被wait，就会唤醒优先级高的
 * notifyAll():一旦执行此方法。就会唤醒所有被wait的线程
 *
 * 说明：
 * 1.三个方法必须使用在同步代码块或同步方法中
 * 2。三个方法的调用者必须是同步代码块或同步方法的同步监视器，否则会出现IllegalMonitorStateException异常
 * 3.三个方法是定义在java.lang.Object类中的
 *
 * 面试题：
 * sleep()与wait()异同
 *  同： 都可以使当前线程进入阻塞状态
 *  异： ① 声明位置不同：Thread()类中sleep()，Object类中wait()
 *      ② 调用范围不同：wait()必须使用在同步代码块或同步方法中,sleep()任何需要可以调用
 *      ③ sleep()不会释放同步监视器，wait()会释放同步监视器
 *
 *
 * @author: 86173
 * @date: 2021/4/11 10:34
 */
class Number implements Runnable {

    private int number = 1;

    private Object obj = new Object();
    @Override
    public void run() {

        while (true) {
            synchronized (obj) {//this

                obj.notify();

                if (number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //调用wait()进入阻塞状态
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}


public class CommunicationTest {
    public static void main(String[] args) {

        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
