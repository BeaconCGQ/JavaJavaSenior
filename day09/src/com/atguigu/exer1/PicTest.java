package com.atguigu.exer1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
  *
  *图片加密
  * @author: 86173
  * @date: 2021/4/21 20:37
  */
public class PicTest {

    //加密
    @Test
    public void test1(){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("LJJ.jpg");
            fos = new FileOutputStream("LJJSec.jpg");

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                //字节数组修改(增强for错误）
                for(int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test2(){

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("LJJSec.jpg");
            fos = new FileOutputStream("LJJ1.jpg");

            byte[] buffer = new byte[20];
            int len;
            while((len = fis.read(buffer)) != -1){
                //字节数组修改(增强for错误）
                for(int i = 0; i < len; i++){
                    buffer[i] = (byte)(buffer[i] ^ 5);
                }

                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
