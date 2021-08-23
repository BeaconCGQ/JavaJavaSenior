package com.atguigu.java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
  * TCP使用：
  *  从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
  *
  * @author: 86173
  * @date: 2021/4/22 15:50
  */
public class TCPTest2 {
    @Test
    public void client() throws IOException {

        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        //2.
        OutputStream os = socket.getOutputStream();

        //3.
        FileInputStream fis = new FileInputStream(new File("LJJ.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        socket.shutdownOutput();//关闭数据输出

        //5.接受来自服务器端的反馈，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while((len1 = is.read(buffer1)) != -1){
         baos.write(buffer1,0,len1);
        }
        System.out.println(baos.toString());

        //6.
        fis.close();
        os.close();
        socket.close();
        baos.close();

    }

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("LJJ3.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        //服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，图片收到".getBytes());

        //关闭资源
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }
}
