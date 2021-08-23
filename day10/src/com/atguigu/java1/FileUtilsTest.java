package com.atguigu.java1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
  * @description:
  * @author: 86173
  * @date: 2021/4/22 14:04
  */
public class FileUtilsTest {
     public static void main(String[] args) {

         File srcFile = new File("day10\\LJJ.jpg");
         File destFile = new File("day10\\LJJ2.jpg");
         try {
             FileUtils.copyFile(srcFile,destFile);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

}
