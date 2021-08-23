package exer3;

import java.util.Date;

/**
  * 定义一个person类，属性如下：
  * （1）身份证号，性别，姓名，年龄，户籍，出生日期（Data类型，需要引用java.uitl.Data）功能：
  * （2）自我介绍：介绍格式：（toString）
  * 身份证号+姓名+户籍
  * （3）提供对象比较equals方法，只要身份证号+姓名相同就认为对象相等
  * @author: 86173
  * @date: 2021/4/16 20:44
  */
public class PersonTest1 {
    public static void main(String[] args) {

        Person1 p1 = new Person1("340321","cgq","男",15,new Date());
        Person1 p2 = new Person1("340321","cgq","女",20,new Date());

        boolean equals = p1.equals(p2);
        System.out.println(equals);

        String s = p1.toSting();
        System.out.println(s);

    }
}

class Person1{

    private String identifier;
    private String name;
    private String gender;
    private int age;
    private Date date;

    public Person1() {
    }

    public Person1(String identifier, String name, String gender, int age, Date date) {
        this.identifier = identifier;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.date = date;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Date getDate() {
        return date;
    }

    public String toSting(){

        return "身份证号：\t" + identifier + "\t姓名：\t" + name + "\t年龄:\t" + age;
    }
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o instanceof Person1){
            Person1 o1 = (Person1) o;
            return this.getName().equals(o1.getName()) && this.getIdentifier().equals(o1.getIdentifier());
        }
        return false;

    }


}
