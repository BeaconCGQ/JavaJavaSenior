package exer9;

/**
  * 定义一个抽象类Person，有name,age,sex三个属性，创建构造函数，给这三个属性赋值，
  * 重写打印描述信息方法，打印三个属性值；
  * 这个类中有两个抽象方法work和hello；定义两个子类Teacher，Student；
  * 教师的work实现是：教书育人，hello实现是：“同学好”；学生的work实现是：认真学习，hello实现是“老师好”。
  * @author: 86173
  * @date: 2021/4/20 12:57
  */
public class PersonTest {
    public static void main(String[] args) {

        Teacher p =new Teacher();
        p.hello();
        p.work();
        String s = p.toString();
        System.out.println(s);


    }
}

abstract class Person{

    private String name;
    private int age;
    private String sex;

    public Person() {

        this.name = "Tom";
        this.age= 12;
        this.sex = "男";
    }

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public abstract void work();
    public abstract void hello();
}

class Teacher extends Person{
    public Teacher(String name, int age, String sex) {
        super(name, age, sex);
    }

    public Teacher() {
    }

    public void work(){
        System.out.println("教书育人");
    }

    public void hello(){
        System.out.println("同学好");
    }

    @Override
    public String toString() {
        return "Teacher{} " + super.toString();
    }
}

class Student extends Person{

    public Student(String name, int age, String sex) {
        super(name, age, sex);
    }

    public Student() {
    }

    public void work(){
        System.out.println("认真学习");
    }
    public void hello(){
        System.out.println("老师好");
    }

    public String toString(){
        return "Teacher{}" + super.toString();
    }
}