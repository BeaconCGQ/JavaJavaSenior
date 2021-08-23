package exer9;
 /**
  * 定义Shape抽象类，包含私有属性color，创建构造器为color赋值；
  * 包含计算周长的方法celPerimeter();
  * 定义子类Triangle，包含三边；定义子类Circle，包含半径radius；
  * 子类分别实现父类的计算周长功能。
  * @author: 86173
  * @date: 2021/4/20 13:15
  */
public class ShapeTest {
     public static void main(String[] args) {

         Shape s = new Triangle(2.3,4.5,3.5);
         double v = s.celPerimeter();
         System.out.println(v);

         Circle c = new Circle(3.4);
         double v1 = c.celPerimeter();
         System.out.println(v1);
     }
}

abstract class Shape{

    private double color;

    public Shape() {
    }

    public Shape(double color) {
        this.color = color;
    }
    public abstract double celPerimeter();
}

class Triangle extends Shape{

    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double celPerimeter(){

        return a + b + c;
    }
}

class Circle{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double celPerimeter(){

        return 2 * Math.PI * radius;
    }
}
