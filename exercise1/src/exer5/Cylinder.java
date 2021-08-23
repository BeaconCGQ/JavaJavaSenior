package exer5;
 /**
  * Cylinder.java文件，在该文件中定义圆柱体类Cylinder，该类在cylinder包中，继承圆类。
  * 属性：圆柱体高度height。
  * 方法：构造器；求表面积方法area()；求体积方法volume()。
  *
  * @author: 86173
  * @date: 2021/4/20 10:01
  */
public class Cylinder extends Circle{

    private double height;

     public Cylinder() {
     }

     public Cylinder(double radius, double height) {
         super(radius);
         this.height = height;
     }

     public double area(){

         return super.area() * 2 + getRadius() * 2 * Math.PI * height;
     }

     public double volume(){

         return super.area() * height;
     }

 }
