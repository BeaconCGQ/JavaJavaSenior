package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
  * 了解类的加载器
  *
  * @author: 86173
  * @date: 2021/4/23 12:58
  */
public class ClassLoaderTest {
    @Test
    public void test1(){

        //对应自定义类，使用类的加载我进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类加载器的getParent()方法：获得扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用系统类加载器的getParent()方法：无法获得引导类加载器
        //引导类加载器负责加载java核心类库，无法加载自定义的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

    }

    /**
     *  Properties: 读取配置文件
     *
     */
    @Test
    public void test2() throws Exception {

        Properties pros = new Properties();
        //文件默认当前module
        //方式一：
//        FileInputStream fis = new FileInputStream("jdbc1.properties");
//        pros.load(fis);
        //方式二：使用ClassLoader
        //文件默认为当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println(user);
        System.out.println(password);
    }

    @Test
    public void test3() throws IOException {

          Properties pros = new Properties();
//        FileInputStream fis = new FileInputStream("jdbc1.properties");
//        pros.load(fis);

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("user");
        System.out.println(user);

    }
}
