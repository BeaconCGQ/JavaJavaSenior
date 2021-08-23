package com.atguigu.java;
 /**
  *Thread 常用方法测试
  * 1.start():启动当前线程，调用当前线程的run()
  * 2，run():通常需要重写此方法，将创建线程要执行的操作写在此方法中
  * 3.currentThread()：静态方法，返回执行当前代码的线程
  * 4.getName(): 获取当前线程的名字
  * 5.setName(): 设置当前线程的名字
  * 6.yield():释放当前cpu的执行
  * 7.join(): 在线程A中调用线程B的join方法,此时线程A进入阻塞状态，直到线程B完全执行完成以后，线程A才结束阻塞状态
  * 8.stop(): 已过时，当执行此方法时，强制结束当前线程
  * 9.sleep(Long millitime): 让当前线程"睡眠"，指定的millitime毫秒时间内，当前线程是阻塞状态
  * 10.isAlive():判断当前线程是否存活
  *
  *线程优先级：
  * 1.
  * MAX_PRIORITY：10
  * MIN _PRIORITY：1
  * NORM_PRIORITY：5  //默认优先级
  * 2.如何设置当前线程优先级
  * getPriority():获取优先级
  * setPriority(int p): 设置优先级
  *
  * 说明：高优先级线程抢占低优先级线程CPU的执行权，但这是从概率上讲，并不意味着高优先级线程执行完以后低优先级才执行
  *
  *
  * @author: 86173
  * @date: 2021/4/10 10:54
  */

 class  HelloThread extends Thread{

     @Override
     public void run() {

         for (int i = 0; i < 100; i++){
             if(i % 2 == 0){

                 try {
                     sleep(10);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }

                 System.out.println(Thread.currentThread().getName()+ ":" +Thread.currentThread().getPriority() + ":" + i);
             }
             if (i % 20 == 0){
                 this.yield();
             }
         }
     }

     public HelloThread(String name){

         super(name);
     }
 }



public class ThreadMethodTest {
    public static void main(String[] args) {


        HelloThread h1 = new HelloThread("Thread:1");
//      h1.setName("线程一");

        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);

        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        for (int i = 0; i < 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+ ":" + Thread.currentThread().getPriority() + ":" + i);
            }
            if( i == 20){
                try {
                    h1.join(); //分线程20以前会有交互，等到分线程执行到20，主线程就会接着执行完毕再接着执行分线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(h1.isAlive());
    }
 }
