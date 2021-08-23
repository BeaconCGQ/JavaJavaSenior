package com.atguigu.java;

/**
 * 使用enum关键字定义枚举类
 * 说明：定义的枚举类继承于 java.lang.Enum
 *
 * @author: 86173
 * @date: 2021/4/13 15:58
 */
public class SeasonTest1 {
    public static void main(String[] args) {

        Season1 summer = Season1.SUMMER;

        //toString方法：
        System.out.println(summer);

//        System.out.println(Season1.class.getSuperclass());
        System.out.println("***********************");
        //values()：
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);//输出对象
            values[i].show();

        }

        Thread.State[] values1 = Thread.State.values();//线程状态
        for (int i = 0; i < values1.length; i++) {

            System.out.println(values1[i]);
        }

        System.out.println("**********************");

        //valueOf(String str) ：返回枚举类对象名是objName的对象
        //若没有，则抛出异常 IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER");
//        Season1 winter1 = Season1.valueOf("WINTER1");
//        System.out.println(winter1);

        winter.show();
    }

}

interface Info{

    void show();
}


//自定义枚举类
enum Season1 implements Info{

    //1.提供当前枚举类的对象，多个对象之间用逗号，末尾对象分号结束
    SPRING("春天", "温暖"){
        @Override
        public void show() {
            System.out.println("季节是春天");
        }
    },
    SUMMER("夏天", "炎热"){
        @Override
        public void show() {
            System.out.println("季节是夏天");
        }
    },
    AUTUMN("秋天", "凉爽"){
        @Override
        public void show() {
            System.out.println("季节是秋天");
        }
    },
    WINTER("冬天", "寒冷"){
        @Override
        public void show() {
            System.out.println("季节是冬天");
        }
    };

    //1.声明Season对象的属性:private + final修饰
    String seasonName;
    String seasonDesc;

    //2.私有化构造器,并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;

    }


    //诉求：获取属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

//    //诉求：
//    @Override
//    public String toString() {
//        return "Season{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
