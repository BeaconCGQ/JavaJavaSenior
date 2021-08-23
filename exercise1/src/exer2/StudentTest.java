package exer2;
 /**
  * 编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。
  * 类中声明一个say方法，返回String类型，方法返回信息中包含所有属性值。
  * 在另一个StudentTest类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用结果打印输出。
  * @author: 86173
  * @date: 2021/4/15 20:14
  */
public class StudentTest {
    public static void main(String[] args) {

        Student s = new Student();
        String say = s.say();
        System.out.println(say);
        System.out.println(s.name);    }
}

class Student{

    String name = "Tom";
    String gender = "男";
    int age = 12;
    int id = 101;
    double score = 65.0;

    public String say(){
        return name + " " + gender + " " + id + " " + age + " " + score;
    }

}