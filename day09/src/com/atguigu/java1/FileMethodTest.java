package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
  *  File类的获取功能
  *  public String getAbsolutePath()：获取绝对路径
  *  public String getPath() ：获取路径
  *  public String getName() ：获取名称
  *  public String getParent()：获取上层文件目录路径。若无，返回null
  *  public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
  *  public long lastModified() ：获取最后一次的修改时间，毫秒值
 *
 *  适用于文件目录：
  *  public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
  *  public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
 *
 *  File类的重命名功能
 * public boolean renameTo(File dest):把文件重命名为指定的文件路径
 *
 *  File类的判断功能
 *  public boolean isDirectory()：判断是否是文件目录
 *  public boolean isFile() ：判断是否是文件
 *  public boolean exists() ：判断是否存在
 *  public boolean canRead() ：判断是否可读
 *  public boolean canWrite() ：判断是否可写
 *  public boolean isHidden() ：判断是否隐藏
  *
  * @author: 86173
  * @date: 2021/4/19 13:30
  */
public class FileMethodTest {
    @Test
    public void test1(){

        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParentFile());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println("***********************");

        System.out.println(file2.getAbsoluteFile());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParentFile());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }
    @Test
    public void test2(){

        File file = new File("C:\\Users\\86173\\IdeaProjects\\JavaSenior");
        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f);
        }

    }

    @Test
    public void test3(){
        /*
        public boolean renameTo(File dest):把文件重命名为指定的文件路径
        要保证成功true，需要file1存在，file2不能在硬盘中存在
         */

        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);

    }
    @Test
    public void test4(){
        /*
         public boolean isDirectory()：判断是否是文件目录
        *  public boolean isFile() ：判断是否是文件
        *  public boolean exists() ：判断是否存在
        *  public boolean canRead() ：判断是否可读
        *  public boolean canWrite() ：判断是否可写
         *  public boolean isHidden() ：判断是否隐藏
         */

        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.exists());
        System.out.println(file1.isFile());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

    }

}
