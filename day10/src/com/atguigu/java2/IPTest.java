package com.atguigu.java2;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class IPTest {
    @Test
    public void test1() throws IOException {

        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket socket  = new Socket(inet,8890);
        OutputStream gos = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("LJJ.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            gos.write(buffer,0,len);
        }

        fis.close();
        gos.close();
        socket.close();
    }

    @Test
    public void test3() throws IOException {

        ServerSocket ss = new ServerSocket(8890);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();

        FileOutputStream fos= new FileOutputStream("LJJ1.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        fos.close();
        is.close();
        socket.close();

    }
}
