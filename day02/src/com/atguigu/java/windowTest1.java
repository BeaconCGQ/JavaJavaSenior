package com.atguigu.java;

/**
  * 例子：创建三个窗口卖票，总票数100张，使用Runnable接口方式
  *
  *  问题：卖票过程出现重票和错票-->出现线程安全问题
  *   1.原因：当某个线程操作车票过程未完成时，其他线程参与进来也操作车票
  *   2.解决：当一个线程a操作时，其他线程不能参与进来，即使线程a出现阻塞也不能改变
 *    3.在java中，通过同步机制来解决线程安全问题
 *
 *       ① 同步代码块:
 *          synchronized(同步监视器){
 *              //需要同步的代码
 *          }
 *         说明：操作共享数据的代码即为需要同步的代码
 *              共享数据：多个线程共同操作的变量，比如: ticket
 *              同步监视器："锁"，任何一个类的对象
 *                  要求：多个线程共用同一把"锁"
 *         补充：实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器
 *              继承Thread类创建多线程方式中，慎用this当同步监视器，考虑使用当前类充当同步监视器
 *
 *       ② 同步方法:
 *           如果操作共享数据的代码完整声明在一个方法中，将此方法声明为同步的
 *
 *
 *    4.同步方式解决了线程安全问题，但操作同步代码时，只有一个线程参与，相当于单线程，效率低
 *
  *
  * @author: cgq
  * @date: 2021/4/10 15:10
  */

 class window1 implements  Runnable{

     private int ticket = 100;

//     Object obj = new Object();

     @Override
     public void run() {
         while(true){
             synchronized (this){//synchronized (obj) {  //this表示唯一的window1对象
                 if (ticket > 0) {

                     try {
                         Thread.sleep(10);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }//即使阻塞也不会重票错票

                     System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                     ticket--;
                 } else {
                     break;
                 }
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
