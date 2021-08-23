package com.atguigu.java1;

/**
  * 静态代理举例
 *
 * 特点：代理类与被代理类编译期间就确定下来
  *
  * @author: 86173
  * @date: 2021/4/24 9:15
  */
public class StaticProxyTest {
    public static void main(String[] args) {

        //创建被代理类对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类对想
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }


}

interface ClothFactory{

    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {

        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些收尾工作");

    }
}

//被代理类
class NikeClothFactory implements ClothFactory{


    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产运动服");
    }
}
