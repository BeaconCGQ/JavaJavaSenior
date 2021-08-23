package exer1;

/**
 * 模拟一个人生产50个玩具，每200毫秒生产一个，
 * 当生产到第20个加入每秒吃1个馒头，共吃完3个后在接着生产的多线程。
 *
 * @author: 86173
 * @date: 2021/4/20 20:01
 */
public class JoyTest {
    public static void main(String[] args) {

        Production p = new Production();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.start();
        t2.start();
    }
}

class Production implements Runnable {

    private int joyCount = 0;
    private int i = 1;
    boolean isFlag = true;

    public  void run() {


        while (isFlag) {

            synchronized (this){

                while (joyCount >= 20) {
                    if (i > 3) {
                        break;
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("开始吃第" + (i++) + "个馒头");
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                joyCount++;
                System.out.println(Thread.currentThread().getName() + "开始生产第" + joyCount + "个产品");
                if(joyCount == 50){
                    isFlag = false;
                }

            }
        }

    }

}