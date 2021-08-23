package exer3;
 /**
  *按要求实现下列问题：实现一个名为Person的类和它的子类Employee，Employee有两个子类Faculty和Staff。具体要求如下：
  * 1）Person类中的属性有：姓名name（String类型），地址address（String类型），
  * 电话号码telephone（String类型）和电子邮件地址email（String类型）；
  * 2）Employee类中的属性有：办公室office（String类型），工资wage（double
  * 类型），受雇日期hireDate（String类型）；
  * 3）Faculty类中的属性有：学位degree（String类型），级别level（String类型）；
  * 4）Staff类中的属性有：职务称号duty（String类型）。
  * 5）现有对象Person p1 =new Faculty()和Person p2 =new Staff ()，请分别为p1的属性赋值“本科”和Staff类的duty赋值“职员”
  * @author: 86173
  * @date: 2021/4/16 20:17
  */
public class PersonTest {
     public static void main(String[] args) {

         Person p1 =new Faculty();
         Faculty p3 = (Faculty) p1;
         p3.setDegree("本科");

         Person p2 =new Staff ();
         Staff p4 = (Staff) p2;
         p4.setDuty("职员");


     }
}

class Person{

    private String name;
    private String address;
    private String telephone;
    private String email;

    public Person() {
    }

    public Person(String name, String address, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Employee extends Person{

    private String office;
    private double wage;
    private String hireData;

    public Employee() {
    }

    public Employee(String office, double wage, String hireData) {
        this.office = office;
        this.wage = wage;
        this.hireData = hireData;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getHireData() {
        return hireData;
    }

    public void setHireData(String hireData) {
        this.hireData = hireData;
    }
}


class Faculty extends Employee{

    private String degree;
    private String level;

    public Faculty() {
    }

    public Faculty(String degree, String level) {
        this.degree = degree;
        this.level = level;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

class Staff extends Employee{

    private String duty;

    public Staff() {
    }

    public Staff(String duty) {
        this.duty = duty;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}


