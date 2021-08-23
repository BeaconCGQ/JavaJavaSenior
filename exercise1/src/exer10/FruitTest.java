package exer10;
 /**
  * 有一个农场公司，专门向市场销售各类水果，主要包括下列水果：葡萄　Grape，草莓　Strawberry，苹果　Apple；
  * 有一个Fruit接口，包含grow生长，harvest收获和plant方法，葡萄、草莓和苹果都实现了这个接口；
  * 有一个农场园丁类FruitGardener，具有采摘水果的方法getFruit(String fruitName)；
  * 这时有人来果园玩，和园丁说介绍一下你的各种水果(创建一个People类进行测试，分别通过农场园丁类得到各种水果)。
  * @author: 86173
  * @date: 2021/4/20 13:45
  */
public class FruitTest {
     public static void main(String[] args) {

         FruitGardener.getFruit("apple").grow();

     }

}

interface Fruit{

    void grow();
    void harvest();
    void plant();

}

class Grope implements Fruit{

    @Override
    public void grow() {
        System.out.println("葡萄生长");

    }

    @Override
    public void harvest() {
        System.out.println("葡萄收获");

    }

    @Override
    public void plant() {
        System.out.println("葡萄种植");
    }


}

class Strawberry implements Fruit{


    @Override
    public void grow() {
        System.out.println("草莓生长");
    }

    @Override
    public void harvest() {
        System.out.println("草莓收获");
    }

    @Override
    public void plant() {
        System.out.println("草莓种植");
    }
}

class Apple implements Fruit{


    @Override
    public void grow() {
        System.out.println("苹果生长");
    }

    @Override
    public void harvest() {
        System.out.println("苹果收获");
    }

    @Override
    public void plant() {
        System.out.println("苹果种植");
    }
}

class FruitGardener{

    public static Fruit getFruit(String fruitName){

        if ("apple".equalsIgnoreCase(fruitName)){
           return new Apple();
        }else if("grape".equalsIgnoreCase(fruitName)){
           return new Grope();
        }else if("strawberry".equalsIgnoreCase(fruitName)){
            return new Strawberry();
        }else{
            throw new RuntimeException("输入数据有误");
        }


    }


}