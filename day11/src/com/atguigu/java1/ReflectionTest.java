package com.atguigu.java1;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * 如何看待反射机制与封装性？
 *   通过直接new+构造器和反射 都可调用类的结构，建议用new+构造器
 *
 * 什么时候使用反射：
 *   反射特征：动态性
 *
 * 封装性与反射不矛盾：
 *
 * //万事万物皆对象？ 对象.xxx /File /URL /反射/前端、数据库
 *
 * @author: 86173
 * @date: 2021/4/23 10:07
 */
public class ReflectionTest {

    //反射之前，对于Person类操作：
    @Test
    public void test1() {

        //1.创建Person类的实例
        Person p1 = new Person("Tom", 12);
        //2.通过对象调用属性、方法
        p1.age = 18;
        System.out.println(p1);
        p1.show();

        //在Person类外部，不可以通过Person类对象调用私有结构
    }

    //反射之后：
    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;
        //1.通过反射，创建Person类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person)obj;
        //2.通过反射，调用对象指定属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);
        System.out.println("*************************");

        //通过反射，调用私有结构
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Jack");
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation =(String) showNation.invoke(p1,"中国");//相当于String nation = p1.showNation("中国");
        System.out.println(nation);

    }
    /**
     * 关于java.lang.Class类的理解
     * 1.类的加载过程：
     *  程序经过javac.exe以后，会生成一个或多个字节码文件(.class)。
     *  接着使用java.exe对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程称为类的加载。
     *  加载到内存中类称为运行时类，此运行时类称为Class的一个实例。
     * 2.Class的实例对应这一个运行时类
     * 3.加载到内存中的运行时类，会缓存一旦时间，在此时间之内，可以通过不同方式获取此运行时类
     *
     */
    //获取Class的实例方式（前三种方式掌握）
    @Test
    public void test3() throws ClassNotFoundException {


        //方式一：调用运行时类的属性
        Class class1 = Person.class;
//        System.out.println(class1);

        //方式二：通过运行时类的对象调用getClass()
        Person p1 = new Person();
        Class class2 = p1.getClass();
//        System.out.println(class2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class class3 = Class.forName("com.atguigu.java1.Person");
//        Class class3 = Class.forName("java.lang.String");
        System.out.println(class3);

        System.out.println(class1 == class2);
        System.out.println(class2 == class3);

        //方式四：类的加载器ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class class4 = classLoader.loadClass("com.atguigu.java1.Person");
        System.out.println(class4 == class1);

    }
    //Class实例
    @Test
    public void test4(){



        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }





}
