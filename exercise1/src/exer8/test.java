package exer8;
 /**
  * 计算器具有work方法，功能是运算，时钟同样具有work方法，功能是计时，有一个手机类Cellphone，
  * 同时需要拥有运算和计时功能，通过内部类实现多继承效果。
  * @author: 86173
  * @date: 2021/4/20 11:03
  */
 public class test{
     public static void main(String[] args) {

         Cellphone c = new Cellphone();

         c.work1();
         c.work2();

     }

 }


class Calculator {

   public void work(){
       System.out.println("计算");
   }
}

class clock {

    public void work(){
        System.out.println("计时");
    }

}

class Cellphone{

    private class test1 extends Calculator{

        public void work(){
            super.work();
        }
    }
    private class test2 extends clock{

        public void work(){
            super.work();
        }
    }

    public void work1(){

       new test1().work();
    }
    public void work2(){
        new test2().work();
    }

}

