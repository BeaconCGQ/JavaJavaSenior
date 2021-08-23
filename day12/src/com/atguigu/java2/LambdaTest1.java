package com.atguigu.java2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式使用：
 *
 * 1.举例：(o1,o2)  -> Integer.compare(o1,o2);
 * 2.格式：
 * ->:Lambda操作符 或 箭头操作符
 * 左边：形参列表（就是接口中的抽象方法的形参列表）
 * 右边：Lambda体（就是重写的抽象方法的方法体）
 *
 * 3.Lambda表达式使用：（分6中情况）
 *
 * 总结：
 *   -> 左边：Lambda形参列表的参数类型可以省略：如果形参列表只有一个参数，括号()也可以省略
 *   -> 右边：Lambda体使用{}包裹：如果Lambda只有一条执行语句（可能为return语句)，可以省略一对{}和return关键字
 *
 * 4.Lambda表达式本质：作为接口的实例（接口要求为只有一个抽象方法）
 *
 * 5.函数式接口：一个接口中只声明了一个抽象方法，在一个接口上使用 @FunctionalInterface 注解，这样做可以检 查它是否是一个函数式接口。
 *
 * 6.以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 *
 * @author: 86173
 * @date: 2021/4/24 10:46
 */
public class LambdaTest1 {
    //格式一：无参无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {

                System.out.println("我在安徽");
            }
        };

        r1.run();

        System.out.println("*******************");

        Runnable r2 = () -> {System.out.println("我在上海");};

        r2.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test2() {
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("cgq");

        System.out.println("*****************");

        Consumer<String> con1 = (String s) -> {System.out.println(s);};
        con1.accept("伤痛文学");
    }
    //语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断
    @Test
    public void test3(){

        Consumer<String> con1 = (s) -> {System.out.println(s);};
        con1.accept("伤痛文学");
    }
    //语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4(){

        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("伤痛文学");
    }
    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println("*************************");

        Comparator<Integer> com2 = (o1,o2) -> {{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        }};
        System.out.println(com2.compare(82,43));

    }

    //语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
    @Test
    public void test6(){

        Comparator<Integer> com1 = (o1,o2) -> {

            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(82,43));

        System.out.println("************************");

        Comparator<Integer> com2 = (o1,o2) ->    o1.compareTo(o2);
        System.out.println(com1.compare(32,3));

    }
}