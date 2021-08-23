package exer5;

/**
  * 该类在默认包中，其中包含主方法main()，在主方法中创建两个圆类对象cir1和cir2，具体尺寸自己确定，并显示圆的面积和周长；
  * 再创建两个圆柱体类的对象cy1和cy2，具体尺寸自己确定，
  * 然后分别显示圆柱体cy1和cy2的底圆的面积和周长以及它们各自的体积和表面积。
  *
  * @author: 86173
  * @date: 2021/4/20 10:06
  */
public class CTest {
    public static void main(String[] args) {

        Circle c1 = new Circle(2.2);
        Circle c2 = new Circle(3.4);

        System.out.println("c1的面积：" + c1.area());
        System.out.println("c2的面积:" + c2.area());
        System.out.println(c1.perimeter());
        System.out.println(c2.perimeter());

        System.out.println("****************");

        Cylinder c3 = new Cylinder(2.2,5.6);
        Cylinder c4 = new Cylinder(3.4,5.6);
        System.out.println(c3.area());
        System.out.println(c4.area());
        System.out.println(c3.volume());
        System.out.println(c4.volume());


    }
}
