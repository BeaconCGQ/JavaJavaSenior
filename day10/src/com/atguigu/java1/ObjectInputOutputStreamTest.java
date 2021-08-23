package com.atguigu.java1;

import org.junit.Test;

import java.io.*;

/**
  * 对象流的使用：
  * 1.ObjectInputStreamTest 和 ObjectOutputStreamTest
  * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
  *        以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
  *
 * 3.要想一个java对象是可序列化的，需要满足：见Person类
 *
 * 4.序列化机制
  *
  * @description:
  * @author: 86173
  * @date: 2021/4/22 12:34
  */

public class ObjectInputOutputStreamTest {
     /**
      * 序列化过程：将内存在java对象保存到磁盘中或通过网络输出
      * 使用ObjectOutputStreamTest
      */
     @Test
     public void test1(){
         ObjectOutputStream oos = null;
         try {
             //1.
             oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
             //2.
             oos.writeObject(new String("我在安徽"));
             oos.flush();//刷新操作

             oos.writeObject(new Person("张三",26));
             oos.flush();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             //3.
             if(oos != null){

                 try {
                     oos.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }

     }

    /**
     * 反序列化:将磁盘文件中对象还原为内存中的java对象
     */
    @Test
    public void test2(){

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String )obj;

            Person p = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ois != null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
 }
