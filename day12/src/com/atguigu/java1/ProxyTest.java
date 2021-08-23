package com.atguigu.java1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
  *  动态代理举例：
  *
  * @author: 86173
  * @date: 2021/4/24 9:25
  */
 interface Human{

     String getBelief();

     void eat(String food);

 }
 //被代理类
class SuperMan implements Human{


     @Override
     public String getBelief() {
         return "I believe I can fly";
     }

     @Override
     public void eat(String food) {

         System.out.println("我喜欢吃" + food);
     }
 }

 /*
 想实现动态代理的问题：
   一、如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
   二、通过代理类的对象调用方法时，如何动态的去调用被代理类的通用方法

  */

class ProxyFactory{

    //调用此方法，返回一个代理类对象，解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

       return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//赋值也需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

//当我们通过代理类对象调用方法a时，就会自动调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理类对象调用的方法，也作为被代理类对象要调用的方法
        //obj:被代理类对象
        Object returnValue = method.invoke(obj, args);
        return returnValue;//作为invoke()方法的返回值
    }
}

public class ProxyTest {
    public static void main(String[] args) {

        SuperMan superMan = new SuperMan();
        //proxyInstance即为代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("麻辣烫");

        System.out.println("***********************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory =(ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothFactory.produceCloth();


    }
}
