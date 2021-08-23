package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

/**
  * 处理流之一：缓冲流使用：
  *
  *  1.缓冲流：
  *   BufferedInPutStream
  *   BufferedOutPutStream
  *   BufferedReader
  *   BufferedWriter
  *
  *   2.作用：提供流的读取写入的速度
 *     提高读写速度的原因：内部提供了一个缓冲区
 *
 *   3.处理流：就是“套接”在已有的流的基础上
  *
  *
  * @author: 86173
  * @date: 2021/4/21 15:47
  */
public class BufferedTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File("LJJ.jpg");
            File destFile = new File("LJJ1.jpg");
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制
            byte [] buffer = new byte[10];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层流，再关闭内层流
            if(bos != null){

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动关闭，故内层流关闭可省略
//            fos.close();
//            fis.close();
        }
    }


    public void copyFileBuffered(String srcPath,String destPath){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造处理流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.复制
            byte [] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求：先关闭外层流，再关闭内层流
            if(bos != null){

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动关闭，故内层流关闭可省略
//            fos.close();
//            fis.close();
        }
    }
    @Test
    public void testCopy(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\86173\\Desktop\\cg.mp4";
        String destPath = "C:\\Users\\86173\\Desktop\\cg01.mp4";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";
        copyFileBuffered(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制时间为：" + (end-start));//91

    }
}
