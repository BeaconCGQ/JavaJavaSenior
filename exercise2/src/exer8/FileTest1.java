package exer8;

import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
  * 1. 在指定的路径下新建一个 .txt 文件 "test.txt"，利用程序在文件中写入如下内容：
  *
  * "Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，
  * 是由Sun Microsystems公司于 1995年5月推出的Java程序设计语言和Java平台（即JavaSE, JavaEE, JavaME）的总称。
  * Java 技术具有 卓越的通用性、高效性、平台移植性和安全性，广泛应用于个人PC、数据中心、游戏控制台、科 学超级计算机、移动电话和互联网，
  * 同时拥有全球最大的开发者专业社群。在全球云计算和移动互 联网的产业环境下，Java更具备了显著优势和广阔前景。"
  * @author: 86173
  * @date: 2021/4/24 21:39
  */
public class FileTest1 {
    @Test
    public void test1() throws Exception {

        File file = new File("test.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言，" + "\n" +
                "是由Sun Microsystems公司于 1995年5月推出的Java程序设计语言和Java平台" + "\n" +
                "（即JavaSE, JavaEE, JavaME）的总称。Java 技术具有 卓越的通用性、高效性、平台移植性和安全性，" + "\n" +
                "广泛应用于个人PC、数据中心、游戏控制台、科 学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。" + "\n" +
                "在全球云计算和移动互 联网的产业环境下，Java更具备了显著优势和广阔前景。");

        fw.close();
    }
    //利用程序读取 test.txt 文件的内容, 并在控制台打印
    @Test
    public void test2() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        String s;
        while(( s= br.readLine()) != null){
            System.out.println(s);
        }

    }
    //利用程序复制 test.txt 为 test1.txt
    @Test
    public void test3() throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
        BufferedWriter bw = new BufferedWriter(new FileWriter("test1.txt"));
        char [] cbuf = new char[10];
        int len;
        while((len = br.read(cbuf)) != -1){
            bw.write(cbuf,0,len);
        }

        bw.close();
        br.close();
    }
    //列出当前目录下全部java文件的名称
    @Test
    public void test4(){

        File file1 = new File("test.txt");
        File file2 = file1.getAbsoluteFile().getParentFile();
        String[] file3 = file2.list();
        for(String f : file3){
//            System.out.println(f);
        }

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.canWrite());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file1.getName());
        System.out.println(file1.length());

    }
    @Test
    public void test5() throws IOException {
        //操作D盘下的my.txt文件
        //1)判断my.txt文件是否存在
        //2)若存在则删除;若不存在则创建

        File file1 = new File("D:\\my.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }

    @Test
    public void test6() throws IOException {

        //利用IO操作文件
        //1)利用代码在D盘下创建news文件夹。
        //2)利用代码在news文件夹下创建2个.docx文件，2个.java文件，2个.txt的文件（在控制台打印news文件夹下的.java文件
        File file1 = new File("D:\\news");
//        System.out.println(file1.mkdir());

         File file2 = new File(file1.getAbsoluteFile(),"a.docx");
         file2.createNewFile();
        File file3 = new File(file1.getAbsoluteFile(),"b.docx");
        file3.createNewFile();
        File file4 = new File(file1.getAbsoluteFile(),"c.java");
        file4.createNewFile();

        String[] list = file1.list();
        for( String s: list){
            if(s.endsWith(".java")){
                System.out.println(s);
            }
        }

    }
    @Test
    public void test7() throws IOException {
        //1)利用Java代码创建D:\temp\temp1\temp2共3个文件夹
        //2)在temp文件夹下创建一个1.txt文件内容为hello，创建一个Hello.java文件
        //3)内容为public static void main(String[] args){},在temp1文件夹下创建同样的两个文件
        //4)输出temp文件夹下包括其子文件夹下，所有的.java文件

        File file1 = new File("D:\\temp\\temp1\\temp2");
        System.out.println(file1.mkdirs());

        File file2 = new File("D:\\temp\\1.txt");
        File file3 = new File("D:\\temp\\hello.java");
        System.out.println(file2.createNewFile());

    }

}
