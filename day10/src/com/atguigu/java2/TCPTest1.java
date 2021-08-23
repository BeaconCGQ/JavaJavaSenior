package com.atguigu.java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
  *TCP使用：
  *客户端发送文件给服务端，服务端将文件保存在本地
  *
  * @author: 86173
  * @date: 2021/4/22 15:40
  */
public class TCPTest1 {
    //以下异常应用try-catch-finally结构
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
        //5.
        fis.close();
        os.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {

        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("LJJ2.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        socket.close();
        ss.close();
    }
}
