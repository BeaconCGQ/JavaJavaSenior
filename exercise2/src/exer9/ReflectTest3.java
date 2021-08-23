package exer9;

import java.lang.reflect.Field;

/**
  * 1.定义PrivateTest类，有私有name属性，并且属性值为hellokitty，只提供name的getName的公有方法
  * 2.创建带有main方法ReflectTest的类，利用Class类得到私有的name属性
  * 3.修改私有的name属性值，并调用getName()的方法打印name属性值
  * @description:
  * @author: 86173
  * @date: 2021/4/26 20:11
  */
public class ReflectTest3 {

     public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {

         Class<?> clazz = Class.forName("exer9.PrivateTest");
         PrivateTest p = (PrivateTest) clazz.newInstance();

         Field name = clazz.getDeclaredField("name");
         name.setAccessible(true);
         name.set(p,"Tom");
         System.out.println(p.getName());

     }
}

class PrivateTest{
    private String name = "hellokitty";

    public PrivateTest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}