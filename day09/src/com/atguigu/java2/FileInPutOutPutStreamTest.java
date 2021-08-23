package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

/**
  * 测试FileInPutStream 和 FileOutPutStream
 *
 * 总结：
 *  对于文本文件(.txt/.java/.cpp),使用字符流处理
 *  对于非文本文件(.jpg/.mp3/.doc/.ppt/.avi),使用字节流处理
  *
  *
  * @author: 86173
  * @date: 2021/4/21 14:42
  */
public class FileInPutOutPutStreamTest {
    //使用字节流处理文本文件可能出现乱码
    @Test
    public void testFileInPutStream() {
        FileInputStream fis = null;

        try {
            //1.文件
            File file = new File("hello.txt");

            //2.流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;//每次循环读取字节个数
            while((len = fis.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            try {
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 实现对图片的复制
     */
    @Test
    public void testFileInPutOutPutStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File("LJJ.jpg");
            File destFile = new File("LJJ2.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制
            byte[] buffer = new byte[5];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //指定路径下文件的复制
    public void copyFile(String srcPath ,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void testCopyFile(){

        long start = System.currentTimeMillis();

//        String srcPath = "C:\\Users\\86173\\Desktop\\cg.mp4";
//        String destPath = "C:\\Users\\86173\\Desktop\\cg01.mp4";

        String srcPath = "hello.txt";
        String destPath = "hello3.txt";
        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制时间为：" + (end-start));//201
    }
}
