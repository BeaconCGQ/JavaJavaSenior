package exer3;

public class Demo {
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        int i3 = 128;
        int i4 = 128;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i1 == i3);//包装类自动拆箱


        Base b2 = new Sub();
    }
}

class Base{
    Base(){
        method(100);
    }
    public void method(int i){
        System.out.println("base : " + i);
    }
}

class Sub extends Base{
    Sub(){
        super.method(70);
    }
    public void method(int j){
        System.out.println("sub : " + j);
    }}