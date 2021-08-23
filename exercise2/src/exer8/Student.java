package exer8;

import java.io.Serializable;

public class Student implements Serializable {

    private  static final  long SerialVersionUID = 3453463645745223L;

    private String name;
    private char gender;
    private int age;

    public Student(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
