package com.atguigu.java1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: 86173
 * @date: 2021/4/18 10:50
 */
public class PropertiesTest {

//Properties:常用来处理配置文件。key-value都是String类型

    public static void main(String[] args)  {

        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

//            ClassLoader classLoader = PropertiesTest.class.getClassLoader();
//            InputStream is = classLoader.getResourceAsStream("dbc.properties");//相对于src下路径
//            pros.load(is);


            String name = pros.getProperty("name");
            String password = pros.getProperty("password");
            System.out.println(name);
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
