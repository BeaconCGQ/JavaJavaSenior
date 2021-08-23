package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
  * Java 内置四大核心函数式接口:
  * 消费型接口  Consumer<T>     void accept(T t)
  * 供给型接口 Supplier<T>     返回类型为T的对象，包含方法：T get()
  *
  * 函数型接口  Function<T, R>  对类型为T的对象应用操作，并返回结果。结果是R类型的对象。包含方法：R apply(T t)
  * 断定型接口  Predicate<T>    确定类型为T的对象是否满足某约束，并返回boolean 值。包含方法：boolean test(T t)
  *
  * @author: 86173
  * @date: 2021/4/24 12:37
  */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500,money -> System.out.println("价格为:" + money));

    }
    public void happyTime(double money, Consumer<Double> con){

        con.accept(money);

    }

    @Test
    public void test2(){

        List<String> list = Arrays.asList("北京","南京","东京","天津");

        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(list1);

        System.out.println("****************");

        List<String> list2 = filterString(list,s -> s.contains("京"));
        System.out.println(list2);


    }

    //根据给定的规则过滤集合中字符串，规则有Predicate方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for(String s: list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
