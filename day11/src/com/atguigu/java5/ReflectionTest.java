package com.atguigu.java5;

import com.atguigu.java3.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
  * 调用运行时类中指定结构：属性、方法、构造器
  *
  * @author: 86173
  * @date: 2021/4/23 15:27
  */
public class ReflectionTest {

    //不理想的操作
    @Test
    public void test1() throws Exception {

        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定属性:要求属性声明为public,故通常不采用此方法
        Field id = clazz.getField("id");

        //设置当前属性值
        //set(): 参数1：指明设置哪个对象的属性 参数2：设置值
        id.set(p,101);

        //获取当前属性值：
        //get(): 参数1：指明对象
        int pId = (int) id.get(p);
        System.out.println(pId);

    }

    /**
     * 常用运行时类获取、设置属性操作
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //1.getDeclaredField(String fieldName) : 获取指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性可访问
        name.setAccessible(true);
        //3.设置、获取指定对象的属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));

    }
    /**
     * 如何操作运行时类的方法
     */
    @Test
    public void testMethod() throws Exception{

        Class clazz = Person.class;
        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定方法
        //getDeclaredMethod(): 参数1：指明获取的方法的名称 参数2：指明获取方法的形参列表
        Method show = clazz.getDeclaredMethod("show", String.class);
        /*
        调用方法 invoke() :参数1 方法的调用者 参数2 ：给方法形参赋值的实参
        invoke()的返回值即为调用方法的返回值
         */
        show.setAccessible(true);
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("**********调用静态方法********");

        //private static void showDesc() {}
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnValue1 = showDesc.invoke(Person.class);//参数也可赋为null，静态属于类
        System.out.println(returnValue1);//无返回值则为null
    }
    /**
     * 调用运行时类指定构造器
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // private Person(String name) {}
        Class clazz = Person.class;
        //1.获取指定构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //2.保证此构造器可访问
        constructor.setAccessible(true);

        //3.创建运行时类的对象
        Person p =(Person) constructor.newInstance("Tom");
        System.out.println(p);

    }
}
