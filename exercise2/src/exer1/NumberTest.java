package exer1;

/**
 * 启动两个线程对一个数字i操作
 * 1)其中1个线程每次对i加1
 * 2)另1个线程每次对i减1
 * 各运行20次，结果i的值等于初始值。
 *
 * @author: 86173
 * @date: 2021/4/20 20:57
 */
public class NumberTest {
    public static void main(String[] args) {

        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.start();
        t2.start();
    }

}

class Number implements Runnable {

    private int i = 0;

    public void run() {

        for (int j = 0; j < 40; j++) {
            synchronized (this) {
                if (i == 0) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                } else {
                    i--;
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                }
            }
        }

    }
}
