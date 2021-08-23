package exer9;


public class Student{

    private String name;
    private int age;

    public Student() {
        System.out.println("无参构造器");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}