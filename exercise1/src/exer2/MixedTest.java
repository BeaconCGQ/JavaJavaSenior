package exer2;
 /**
  * 1.  属性：名字，性别，年龄；提供无参的构造器和一个有参的构造器
  * 方法：（1）自我介绍的方法（2）吃饭的方法    创建一个对象“张三”
  *
  * 2.属性：品牌；车长；颜色；价格；
  * 创建五个对象：“捷达”，“宝马”，“劳斯莱斯”，“科鲁兹”，“迈锐宝”
  * 提供无参的构造器和一个有参的构造器
  *
  *3.属性：课程名；学时；任课老师；
  * 创建五个对象：“c语言”，“java编程”，“php网络编程”，“c++”，“数据结构”
  * 提供无参的构造器和一个有参的构造器
  *
  *
  *
  *
  *
  * @author: 86173
  * @date: 2021/4/15 21:56
  */
public class MixedTest {
     public static void main(String[] args) {

         Person p = new Person("Tom","男",15);
         System.out.println(p.toString());
         p.eat();


     }

}

class Person{

    private String name;
    private String gender;
    private int age;

    public Person() {

    }

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public void eat(){
        System.out.println(name + "吃饭");
    }
}


