package exer10;

/**
  * 简单工厂模式
  * 叙述工厂模式的设计理念
  * 有一个交通工具接口Vehicles，有work接方法，有Horse类和Boat类分别实现Vehicles，
  * 创建交通工具工厂类，有两个方法分别获得交通工具Horse和Boat；
  * 有Person类，有name和Vehicles属性，在构造器中赋值，实例化“唐僧”，
  * 一般情况下用Horse作为交通工具，遇到大河时用Boat作为交通工具。
  * @author: 86173
  * @date: 2021/4/20 13:23
  */
public class PersonTest {
    public static void main(String[] args) {

        Person p = new Person("唐僧",null);
        p.passRiver();
        p.passRoad();

    }


}

interface Vehicles{

    public abstract void work();

}

class Horse implements Vehicles{

    public void work(){
        System.out.println("一般情况下使用Horse");
    }
}

class Boat implements Vehicles{
    public void work(){

        System.out.println("遇到大河时使用Boat");
    }

}

class VehicleUse{

    public static Vehicles getVehicles(String user){
        if("一般".equals(user)){
            return new Horse();
        }else if("大河".equals(user)){
            return new Boat();
        }
        throw new RuntimeException("输入有误");

    }
}

class Person{
    private String name;
    private Vehicles v;

    public Person() {


    }

    public Person(String name, Vehicles v) {
        this.name = name;
        this.v = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicles getV() {
        return v;
    }

    public void setV(Vehicles v) {
        this.v = v;
    }

    public void  passRiver(){


        Vehicles v1 = VehicleUse.getVehicles("大河");
        v1.work();

    }
    public void passRoad(){

        Vehicles v2 = VehicleUse.getVehicles("一般");
        v2.work();
    }
}
