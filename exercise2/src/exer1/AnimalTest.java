package exer1;
 /**
  * 编写龟兔赛跑多线程程序，设赛跑长度为100米，每跑完10米输出一次结果。
  * @author: 86173
  * @date: 2021/4/20 20:55
  */
public class AnimalTest {
    public static void main(String[] args) {

        Animal tz = new Animal("兔子");
        Animal wg = new Animal("乌龟");
        tz.start();
        wg.start();
    }
}

class Animal extends Thread{

    private String name;
    boolean isFlag = true;


    public Animal(String name) {
        this.name = name;
    }

    public void run(){

        for(int i = 0; i <= 100 && isFlag; i += 10){


            if("乌龟".equals(name)){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("乌龟跑了" + i + "米");
                if(i == 100){
                    isFlag = false;
                }
            }else{
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("兔子跑了" + i + "米");
                if(i == 100){
                    isFlag = false;
                }
            }

        }
    }
}
