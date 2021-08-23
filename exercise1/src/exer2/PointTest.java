package exer2;

/**
 * 定义一个类，用于描述坐标点
 * 0——————>X
 * |
 * |
 * |          P(X,Y)
 * |
 * |
 * Y
 *
 * （1）具有计算当前点到原点距离的功能
 * （2）求到任意一点（m，n）的距离
 * （3）求到任意一点（Point p）的距离
 * （4）具有坐标点显示功能，显示格式（x，y）
 * （5）提供无参的构造器和一个有参的构造器
 *
 * @author: 86173
 * @date: 2021/4/15 21:21
 */
public class PointTest {
    public static void main(String[] args) {


        Point p = new Point(3.4, 5.6);
        p.Opoint();
        p.Rpoint(2.3,5.6);
        String str = p.toString();
        System.out.println(str);
    }

}

class Point {
    private double x;
    private double y;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void Opoint() {
        System.out.println(Math.sqrt(x * x + y * y));
    }

    public void Rpoint(double m, double n) {

        System.out.println(Math.sqrt((x - m) * (x - m) + (y - n) * (y - n)));
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}