package exer3;
 /**
  * 1）封装一个西游记人物类Person：包含私有属性：姓名（name）、身高（height）、武器（weapon）、种族（race），
  *    并提供访问器（get方法）和修改器（set方法）
  * 2）在测试类中实例化三个对象：tangseng（唐僧）、sunwukong（孙悟空）、baigujing（白骨精），分别设置他们的种族为：人族、仙族、妖族
  * 3）在打印对象时，按照例如：“姓名：孙悟空；种族：仙族”的格式在控制台输出信息。
  * 4）提供一个技能方法void skill()，这个方法根据当前对象name属性判断技能，
  *    如果是孙悟空，就打印“七十二变”，如果是唐僧，就打印“紧箍咒”，如果是白骨精，就打印“九阴白骨爪”，在测试类中调用这个方法。
  * 5）重写equals方法进行判断，如果种族属性是人族或者仙族，则返回true，如果是妖族，则返回false，
  *    在测试类中对孙悟空和唐僧进行比较，打印结果，对唐僧和白骨金进行比较，并打印结果。
  * @author: 86173
  * @date: 2021/4/16 21:23
  */
public class PersonTest2 {

     public static void main(String[] args) {

         Person2 tang = new Person2("唐僧","人族");
         Person2 sun = new Person2("孙悟空","仙族");
         Person2 bai = new Person2("白骨精","妖怪");

         String swk = sun.toString();
//         System.out.println(swk);
         sun.skills();
         tang.skills();




     }
}

class Person2{

    private String name;
    private double height;
    private String weapon;
    private String race;

    public Person2() {
    }

    public Person2(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public Person2(String name, double height, String weapon, String race) {
        this.name = name;
        this.height = height;
        this.weapon = weapon;
        this.race = race;
    }
    //姓名：孙悟空；种族：仙族
    public String toString(){

        return "姓名：" +this.name + ";  种族：" + this.race;
    }

    public void skills(){
        if("孙悟空".equals(name)){
            System.out.println("七十二变");
        }else if("唐僧".equals(name)){
            System.out.println("紧箍咒");
        }else if ("白骨精".equals(name)){
            System.out.println("九阴白骨爪");
        }else{
            System.out.println("输入有误");
        }

    }


}