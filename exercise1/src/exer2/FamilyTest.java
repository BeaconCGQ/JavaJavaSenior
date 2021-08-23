package exer2;
 /**
  * 定义一个丈夫Husband类，有姓名、年龄、妻子属性
  * 定义一个妻子Wife类，有姓名、年龄、丈夫属性
  * 丈夫类中有一个getInfo方法，其中，能显示自己的姓名，年龄，和他的妻子的姓名，年龄
  * 妻子类中有一个getInfo方法，其中，能显示自己的姓名，年龄，和她的丈夫的姓名，年龄
  * 定义一个测试类，创建妻子和丈夫对象，然后测试
  *
  *
  * @author: 86173
  * @date: 2021/4/15 20:20
  */
public class FamilyTest {
     public static void main(String[] args) {

         Husband man = new Husband();

         Wife woman = new Wife();
         man.setName("Tom");
         man.setAge(26);
         woman.setName("Sherry");
         woman.setAge(24);
         woman.setHusband(man);

         man.setWife(woman);
         man.getInfo();
         woman.getInfo();



     }
}

class Husband{
    private  String name ;
    private  int age ;
    private Wife wife ;

    public Husband() {
    }

    public Husband(String name, int age, Wife wife) {
        this.name = name;
        this.age = age;
        this.wife = wife;
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

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public void getInfo(){

        System.out.println(name + " " + age + " " + wife.getName() + " " + wife.getAge());
    }


}

class Wife{
    private String name ;
    private int age  ;
    private Husband husband ;

    public Wife() {
    }


    public Wife(String name, int age, Husband husband) {
        this.name = name;
        this.age = age;
        this.husband = husband;
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

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public void getInfo(){
        System.out.println(name + " " + age +  " " + husband.getName() + " " + husband.getAge());

    }


}