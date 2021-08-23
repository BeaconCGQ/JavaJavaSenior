package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现Callable接口 （jdk5.0新增)
 *
 * 如何理解实现Callable接口的方式创建多线程方式比实现Runnable接口创建多线程方式更强大？
 *    1.call()可以有返回值
 *    2.call()可以抛出异常，被外面的操作捕获，获取异常信息
 *    3.Callable支持范型
 *
 * @author: 86173
 * @date: 2021/4/11 12:20
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable {

    //2.实现call方法，将此线程需要执行的操作声明在call()方法中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;

            }
        }
        return sum;
    }
}


public class CallableTest {

    public static void main(String[] args) {

        //3.创建Callable接口实现类的对象
        NumThread num = new NumThread();

        //4.将此对象作为参数传递到FutureTask的构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(num);

        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call()的返回值（可忽略）
            //get()方法返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
