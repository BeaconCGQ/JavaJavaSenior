package com.atguigu.java2;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
  * 一、网络编程中有两个主要的问题：
  * 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
  * 找到主机后如何可靠高效地进行数据传输
  *
  * 二、网络编程的两个要素：
  * 1.IP和端口号
  * 2.提供网络通信协议：TCO/IP模型（应用层、传输层、网络层、物理加数据链路层
  *
  * 三、通信要素一：IP和端口号
  * 1.IP: 唯一的标识 Internet 上的计算机（通信实体）
  * 2.在Java中使用InetAddress类表示IP
  * 3.IP分为IPv 和 IPv6 ；万维网 和 局域网
 *  4.域名：  www.baidu.com   www.mi.com  www.sina.com
 *  5.本地回路地址：127.0.0.1  对应 ： Localhost
  * 6：实例化InetAddress ：getByName() 和 getLocalHost()
 *     两个常用方法：getHostName() 和 getHostAddress()
 *
 *  7.端口号：识正在计算机上运行的进程（程序）
 *    要求：不同的进程有不同的端口号
 *    范围：规定为一个 16 位的整数 0~65535。
 *
 *  8.端口号与IP地址的组合得出一个网络套接字：Socket
 *
  * @author: cgq
  * @date: 2021/4/22 14:25
  */
public class InetAddressTest {
  public static void main(String[] args) {

   try {
    InetAddress inet1 = InetAddress.getByName("192.168.10.14");
    System.out.println(inet1);

//    InetAddress inet2 = InetAddress.getByName("www.atguigu.com");
//    System.out.println(inet2);

    InetAddress inet3 = InetAddress.getByName("127.0.0.1");
    System.out.println(inet3);//本地

    //
       InetAddress inet4 = InetAddress.getLocalHost();
       System.out.println(inet4);//本地ip

       //getHostName()
//       System.out.println(inet2.getHostName());//www.atguigu.com
       //getHostAddress()
//       System.out.println(inet2.getHostAddress());//61.184.215.185

   } catch (UnknownHostException e) {
    e.printStackTrace();
   }
  }
}
