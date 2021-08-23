package com.atguigu.java1;

import java.io.Serializable;

/**
 * 序列化满足：
 *   1.实现Serializable接口
 *   2.当前类提供全局常量：serialVersionUID
 *   3.出了当前类需要实现Serializable接口之外，还必须保证其内部所有属性也都是可序列化的（基本数据类型是序列化的）
 *
 * 补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
  * @description:
  * @author: 86173
  * @date: 2021/4/22 12:46
  */
public class Person implements Serializable {
    public static final long serialVersionUID = 4225543634432L;
    private String name;
    public int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
