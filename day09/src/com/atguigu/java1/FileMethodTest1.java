package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
  *  File类的创建功能
  *  public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
  *  public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
  *  public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建
  *   注意事项：如果你创建文件或者文件目录没有写盘符路径，那么，默认在项目路径下。
  *
  * File类的删除功能
  *  public boolean delete()：删除文件或者文件夹
  *删除注意事项：
  *    Java中的删除不走回收站。 要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
  *
  * @author: 86173
  * @date: 2021/4/19 13:59
  */
public class FileMethodTest1 {
    @Test
    public void test1() throws IOException {

        //文件创建
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else {//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test2(){

        //文件目录创建
        File file = new File("D:\\io\\io1");
        boolean mkdir = file.mkdir();
        if(mkdir){
            System.out.println("创建成功");
        }

    }
    @Test
    public void test3(){

        //文件目录创建
        File file1 = new File("D:\\io\\io1\\io3");
        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");//创建失败
        }

        File file2 = new File("D:\\io\\io1\\io4");
        boolean mkdirs = file2.mkdirs();
        if(mkdirs){
            System.out.println("创建成功2");//创建成功
        }
    }

}
