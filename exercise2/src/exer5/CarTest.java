package exer5;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
  *创建Car类，包含name，price属性，构造器等方法，创建测试类，
  * 在main方法中创建Set接口的实现类，添加5个以上的Car对象，遍历集合元素，验证重复元素是否过滤了；
  * 如果没有过滤，实现过滤功能；把每个小车的price降10000元，再遍历，查看price是否已改变
  *
  * @author: 86173
  * @date: 2021/4/23 20:23
  */
public class CarTest {
    public static void main(String[] args) {

        Set<Car> set = new HashSet<>();

        set.add(new Car("BM",2000));
        set.add(new Car("BYD",5000));
        set.add(new Car("BC",4000));
        set.add(new Car("BM",2000));

        for(Car c : set){
            c.show();
            System.out.println(c);
        }





    }
}

class Car{

    private String name;
    private int price;

    public Car() {
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void show(){

        this.price = this.price - 1000;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getPrice() == car.getPrice() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
