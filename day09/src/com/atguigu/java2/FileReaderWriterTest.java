package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

/**
  * 一、流的分类
  *  1.操作数据单位：字节流、字符流
  *  2.数据的流向：输入流、输出流
  *  3.流的角色：节点流、处理流
  *
  * 二、流的体系结构：
  * 抽象基类：               节点流：                                          缓冲流：（处理流的一种）
  * InputStream            FileInPutStream (read(byte[] buffer)             BufferedInPutStream (read(byte[] buffer)
  * OutPutStream           FileOutPutStream (write(byte[] buffer,0,len)     BufferedOutPutStream (write(byte[] buffer,0,len) /flush()
  * Reader                 FileReader (read char[] cbuf)                    BufferedReader     (read char[] cbuf)/(readLine())
  * Writer                 FileWriter (write(char[] cbuf,0,len)             BufferedWriter   (write(char[] cbuf,0,len)  / flush()
  *
 *  flush():刷新缓冲区
  *
  * @author: 86173
  * @date: 2021/4/21 13:06
  */
public class FileReaderWriterTest {

    /*
       将day09的hello.txt文件内容读入程序，并输入到控制台
       说明：read(): 返回读入的一个字符，如果达到文件末尾，返回-1
          异常处理：为了保证流资源一定执行关闭操作，需要用try结构
          读入文件要存在，否则会报FileNotFoundException
     */
    @Test
    public void FileReaderTest() {
        FileReader fr = null;

        try {
            //1.实例化File对象，指明操作文件
            File file = new File("hello.txt");//相较于当前module的相对路径

            //2.提供具体的流
            fr = new FileReader(file);

            //3.数据读入
            /**
             *  read(): 返回读入的一个字符，如果达到文件末尾，返回-1
             */
            //方式一：
//        int data = fr.read();
//        while(data != -1) {
//            System.out.print((char) data);
//            data = fr.read();
//        }
            //方式二：
            int data;
            while((data = fr.read())  != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if(fr != null)//  也可以if包含try结构
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对read()操作升级：使用重载方法
    @Test
    public void FileReaderTest1() {
        FileReader fr = null;

        try {
            //1.File类的实例化
            File file = new File("hello.txt");

            //2.FileReader流的实例化
            fr = new FileReader(file);

            //3。读入操作
            //read(char[] cbuf): 返回每次读入到cbuf数组中字符个数
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){
                //方式一：
                for(int i = 0; i < len; i++){ //i < cubf.length 是错误的
                    System.out.print(cbuf[i]);
                }
                //方式二：
//                String str = new String(cbuf);//错误写法
                 String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 从内存写出数据到硬盘中
     * 说明：1.输出操作的File可以不存在，输出时会自动创建此文件
     *      2.如果存在，若流使用构造器是FileWrite(file,false):对原有文件进行覆盖
     *                 若流使用构造器是FileWrite(file,true):对原有文件进行增添
     */
    @Test
    public void FileWriterTest() {
        FileWriter fw = null;

        try {
            //1.提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2.提供FileWriter对象，用于数据写出
            fw = new FileWriter(file,true);

            //3.写出操作
            fw.write("I have a dream!\n");
            fw.write("you need having a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if(fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1.创建File类对象，指明读入和写出的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.读入和写出数据
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出去len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if(fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 不能使用字符流来处理图片等字节型数据
     */
    @Test
    public void test1(){
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1.创建File类对象，指明读入和写出的文件
//            File srcFile = new File("hello.txt");
//            File destFile = new File("hello2.txt");

            //2.创建输入流和输出流的对象
            fr = new FileReader("LJJ.jpg");
            fw = new FileWriter("LJJ1.jpg");

            //3.读入和写出数据
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符个数
            while((len = fr.read(cbuf)) != -1){
                //每次写出去len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
