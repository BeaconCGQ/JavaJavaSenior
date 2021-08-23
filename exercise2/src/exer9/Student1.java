package exer9;

public class Student1 {

    private String name;

    public Student1() {
    }

    @Deprecated
    @MyAnnotation(myname = "我是注解")
    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                '}';
    }
}
