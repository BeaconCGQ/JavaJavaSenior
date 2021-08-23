package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题方式三：Lock锁 -->jdk5.0新增
 *
 *
 * 1.面试题：synchronized 与 lock 异同：
 *   同：解决线程安全问题
 *
 *   异：synchronized机制执行完相应的同步代码以后，自动释放同步监视器
 *      lock需要手动启动(lock()),同时也需要手动实现(unlock())
 *
 *2.优先使用顺序：
 *  Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法
 * （在方法体之外）
 * @author: 86173
 * @date: 2021/4/10 20:11
 */

class window implements Runnable {

    private int ticket = 100;
    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
          try {
              //2.调用锁定lock()
              lock.lock();


              if (ticket > 0) {

                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }

                  System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticket);
                  ticket--;
              } else {
                  break;
              }
          }finally{
              //3.调用解锁方法
              lock.unlock();
            }
        }

    }
}


public class LockTest {
    public static void main(String[] args) {

        window w = new window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();

    }
}
