package com.atguigu.java2;

import org.junit.Test;

import java.io.*;

public class BufferedTest1 {
    /**
       使用BufferedReader 和 BufferedWriter 实现文本复制
     */
    @Test
    public void testBufferedReaderWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            //创建文件和流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作
            //方式一：
//            char [] cbuf = new char[1024];
//            int len;
//            while((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//                bw.flush();
//            }
            //方式二：使用String
            String data;
            while((data = br.readLine()) != null){
                //换行方法一：
//                bw.write(data + "\n");//data中不包含换行符
                //换行方法二：
                bw.write(data);
                bw.newLine();
            }




        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        //关闭资源
        if(br != null){

            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(bw != null){

            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
