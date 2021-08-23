package com.atguigu.java4;

import com.atguigu.java3.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
  * @description:  获取当前运行时类的所有属性
  * @author: 86173
  * @date: 2021/4/23 14:05
  */
public class FieldTest {
    @Test
    public void test1(){

        Class clazz = Person.class;
        //获取属性结构
        //getField(): 获取当前运行时类及其父类中声明为public的属性
        Field[] fields = clazz.getFields();
        for(Field f: fields){
            System.out.println(f);
        }
        System.out.println("*****************");

        //getDeclaredField():   获取当前运行时类的自己声明的所有权限的属性，不包含父类
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            System.out.println(f);
        }
    }
    //权限修饰符  数据类型 变量名
    @Test
    public void test2(){

        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.获取属性的权限修饰符：
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String name = f.getName();
            System.out.print(name);


            System.out.println();
        }
    }
}
