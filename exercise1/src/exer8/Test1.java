package exer8;
 /**
  * 有一个铃声接口类Bell，有一个手机类Cellphone1，具有闹钟功能alarmclock，
  * 参数是Bell类型，测试手机类的闹钟功能，
  * 通过匿名内部类作为参数，打印：懒猪起床了。
  * @author: 86173
  * @date: 2021/4/20 11:19
  */
public class Test1 {
    public static void main(String[] args) {

        new Cellphone1().alarmclock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

    }
}

interface Bell{
   public void ring();

}

class Cellphone1{
    public void alarmclock(Bell bell){

        bell.ring();
    }


}