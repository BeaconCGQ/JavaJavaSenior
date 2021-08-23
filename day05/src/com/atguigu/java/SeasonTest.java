package com.atguigu.java;
 /**
  * 一、枚举类的使用：
  * 1.枚举类理解：当类的对象只有有限个、确定的，称为枚举类
  * 2.当需要定义一组常量时，强烈建议使用枚举类
  * 3.如果枚举类只有一个对象，则可以作为单例模式的实现方式
  *
  * 二、定义枚举类：
  * 方式一：jdk5.0之前，自定义
  * 方式二：jdk5.0，使用enum关键字定义：
  *   说明：定义的枚举类继承于 java.lang.Enum
  *
  * 三、enum常用方法：
  *   values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
  *   valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
  *   toString()：返回当前枚举类对象常量的名称
  *
  * 四、使用enum关键字定义的枚举类实现接口的情况：
  *   情况一：实现接口，在enum类中实现抽象方法
  *   情况二：枚举类对象分别去实现接口中抽象方法
  *
  * @author: 86173
  * @date: 2021/4/13 15:26
  */
public class SeasonTest {
     public static void main(String[] args) {

         S[] values = S.values();
         for (int i = 0; i < values.length; i++) {
             System.out.println(values[i]);

         }

     }

}

//自定义枚举类
class Season{
    //1.声明Season对象的属性:private + final修饰
    private final String seasonName;
    private final String seasonDesc;

    //2.私有化构造器,并给对象属性赋值
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;

    }
    //3.提供当前枚举类的多个对象
    public static final Season SPRING = new Season("春天","温暖");
    public static final Season SUMMER = new Season("夏天","炎热");
    public static final Season AUTUMN = new Season("秋天","凉爽");
    public static final Season WINTER = new Season("冬天","寒冷");

    //4.获取属性


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
