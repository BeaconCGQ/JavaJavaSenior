package com.atguigu.java;
 /**
  * 创建多线程方式二：实现Runnable接口
  * 1.创建实现Runnable接口的类
  * 2.实现类去实现Runnable中的抽象方法：run()
  * 3.创建实现类的对象
  * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
  * 5.通过Thread类的对象调用start()
  *
  *
  *
  * 比较创建两种线程的方式：
  *
  *   开发中优先选择实现Runnable接口方式
  *      原因一：实现的方式没有类的单继承的局限性
  *      愿意二：更适合处理多个线程共享数据的情况
  *  联系： public class Thread implements Runnable
  *  相同点：重写run()，将线程要执行的逻辑声明在run()中
  *
  *
  * @author: 86173
  * @date: 2021/4/10 13:02
  */

 class MThread implements Runnable{
     @Override
     public void run() {
         for (int i = 0; i < 100; i++){
             if (i % 2 == 0){
                 System.out.println(Thread.currentThread().getName() + ":" +i);
             }
         }
     }
 }

public class ThreadTest1 {
    public static void main(String[] args) {

        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.setName("线程一");
        t1.start();

//        再启动一个线程
        Thread t2 = new Thread(mThread);
        t2.setName("线程二");
        t2.start();
    }
}
