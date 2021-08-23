package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
  * RandomAccessFile的使用：
  * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和 DataOutput接口
  * 2.RandomAccessFile既可以作为一个输入流，也可以作为输出流
 *
 *  3.如果RandomAccessFile作为输出流，写出到的文件如果不存在，则文件自动创建，
 *    若文件存在，会对原有文件内容进行覆盖（从头覆盖）
 *
 *  4.也可通过一些操作实现插入效果
 *
 *  //思考：将StringBuilder替换为ByteArrayOutputStream
  *
  * @author: 86173
  * @date: 2021/4/22 13:12
  */
public class RandomAccessFileTest {
    @Test
    public void test1(){

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("LJJ.jpg"),"r");
            raf2 = new RandomAccessFile(new File("LJJ1.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){

                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){

                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");
        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());//覆盖操作

        raf1.close();

    }
    /*
    实现插入效果：将插入位置后面的数据保存，等到覆盖以后在添加进来
     */
    @Test
    public void test3() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile(new File("hello.txt"),"rw");
        raf1.seek(3);
        //保存指针3后面的数据到StringBuilder
        StringBuilder str = new StringBuilder((int)new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf1.read(buffer)) != -1){
            str.append(new String(buffer),0,len);
        }
        //调回指针，写入数据
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //将StringBuilder数据写回来
        raf1.write(str.toString().getBytes());

        raf1.close();

    }

}
