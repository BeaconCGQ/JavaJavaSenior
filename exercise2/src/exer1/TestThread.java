package exer1;
 /**
  * 编写一个继承Thread类的方式实现多线程的程序。该类MyThread有两个属性，
  * 一个字符串WhoAmI代表线程名，一个整数delay代表该线程随机要休眠的时间。
  * 构造有参的构造器，线程执行时，显示线程名和要休眠时间。
  * 另外，定义一个测试类TestThread，创建三个线程对象以展示执行情况。
  *
  * @author: 86173
  * @date: 2021/4/20 19:44
  */
public class TestThread{
     public static void main(String[] args) {

         MyThread m1 = new MyThread("线程一",(int)(Math.random()*100));
         MyThread m2 = new MyThread("线程二",(int)(Math.random()*100));
         MyThread m3 = new MyThread("线程三",(int)(Math.random()*100));

         m1.start();
         m2.start();
         m3.start();

     }

 }

class MyThread extends Thread{

    private String WhoAmI;
    private int delay;

    public MyThread(String WhoAmI, int delay) {
        this.WhoAmI = WhoAmI;
        this.delay = delay;
    }

    public void run(){

        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Hello!I am" + WhoAmI + ",I slept" + delay + "milliseconds");

    }

    public String getWhoAmI() {
        return WhoAmI;
    }

    public void setWhoAmI(String whoAmI) {
        WhoAmI = whoAmI;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}

