package com.atguigu.exer;

 /**
  * 练习：创建两个线程，一个遍历100以内偶数，另一个遍历100以内奇数
  *
  * @author: 86173
  * @date: 2021/4/9 21:01
  */

public class ThreadDemo {
     public static void main(String[] args) {

//         MyThread1 m1 = new MyThread1();
//         MyThread2 m2 = new MyThread2();
//
//         m1.start();
//         m2.start();

          //创建Thread匿名类的匿名子类方式
         new Thread(){
             @Override
             public void run() {
                 for(int i = 0; i < 100; i++){
                     if (i % 2 == 0){
                         System.out.println(Thread.currentThread().getName()+":" +i);
                     }
                 }
             }
         }.start();


         new Thread(){
             @Override
             public void run() {
                 for(int i = 0; i < 100; i++){
                     if (i % 2 == 0){
                         System.out.println(Thread.currentThread().getName()+":" +i);
                     }
                 }
             }
         }.start();
     }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":" +i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+":" +i);
            }
        }
    }
}