package com.atguigu.java1;

import org.junit.Test;

import java.io.File;

/**
 * File类使用：
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录
 * 2.File类声明在java.io包
 * 3.File类涉及关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等操作，并未涉及到写入或读取文件内容的操作，
 *       若涉及这些操作，则需要IO流完成
 * 4.File会作为参数传递到流的构造器中，指明读取或写入的“终点”
 *
 * @author: cgq
 * @date: 2021/4/19 13:12
 */
public class FileTest {
    /**
     * 1.如何创建File类的实例
     * File(String filePath)
     * File(String parentPath,String childPath)
     * File(File parentPath,String childPath)
     *
     * 2.相对路径：相较于某个路径下的路径
     * 绝对路径：包含盘符在内的文件或文件目录的路径
     *
     * 3.路径分隔符
     * window: \\
     * unix: /
     */
    @Test
    public void test1() {

        //构造器 1：
        File file1 = new File("hello.txt");//相对于当前module下
        File file2 = new File("C:\\Users\\86173\\IdeaProjects\\JavaSenior\\day09\\he.txt"); //绝对路径

        System.out.println(file1);
        System.out.println(file2);//输出路径

        //构造器 2：
        File file3 = new File("C:\\Users\\86173\\IdeaProjects", "JavaSenior");//父 子 路径

        //构造器3：
        File file4 = new File(file3, "hi.txt");//C:\Users\86173\IdeaProjects\JavaSenior\hi.txt
        System.out.println(file4);
    }
}
