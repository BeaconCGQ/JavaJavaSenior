package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 *
 * @author: 86173
 * @date: 2021/4/23 13:16
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {

        Class<Person> clazz = Person.class;
        /**newInstance():创建对应的运行时类的对象，内部调用构造器
         此方法要求：运行时类必须提供空参构造器，且访问权限可以访问，通常设置public

         javabean要求提供空参构造器：
         ① 便于提供反射，创建运行时类的对象
         ② 便于子类继承此运行时类，默认调用super()，保证父类有此构造器
         */
        Person p = clazz.newInstance();//默认调空参构造器
    }

    //体会反射动态性
    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        int num = new Random().nextInt(3);//0,1,2
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.atguigu.java1.Person";
                break;
        }
        Object instance = getInstance(classPath);
        System.out.println(instance);


    }

    //创建指定类的对象
    //classPath：指定类的全类名
    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class clazz = Class.forName(classPath);
        return clazz.newInstance();

    }
}
