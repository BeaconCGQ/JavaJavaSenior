package exer5;
 /**
  * Circle.java文件，在该文件中定义圆类Circle，该类在circle包中，实现Shape接口类。
  * 属性：圆半径radius。
  * 方法：构造器；实现求面积方法area()；求周长方法perimeter()。
  *
  * @author: 86173
  * @date: 2021/4/20 9:58
  */
public class Circle implements Shape{

    private double radius;

     public Circle() {
     }

     public Circle(double radius) {
         this.radius = radius;
     }

     public double getRadius() {
         return radius;
     }

     public void setRadius(double radius) {
         this.radius = radius;
     }

     public double area(){

         return  Math.PI * radius * radius;
     }

     public double perimeter(){

         return Math.PI * 2 * radius;
     }
 }
