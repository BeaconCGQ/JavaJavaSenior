package exer1;



import org.junit.Test;

import java.util.Scanner;

public class forTest {
    public static void main(String[] args) {

        /*
          随机生成一个10以内的数，猜数字游戏：
          从键盘输入数，如果大了提示，大了，如果小了，提示小了，如果对了，就不再猜了，并统计一共猜了多少次？

         */
        int num =(int) (Math.random() * 10);

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入10以内整数：");

        int num1;
        int count = 0;
        do{
            num1 = scan.nextInt();
            count++;
            if(num > num1){
                System.out.println("小了");
            }else if (num < num1){
                System.out.println("大了");
            }else{
                System.out.println("猜对了");
                System.out.println("共猜了：" + count + "次");
            }
        }while(num != num1);


    }

    @Test
    public void test1() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("#");
            }
            System.out.println("#");
        }
        System.out.println("*****************");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("*****************");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4-i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("*****************");

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i*j  +"\t");
            }
            System.out.println();
        }

    }
    @Test
    public void test2() {
        /*
        3000米长的绳子，每天减一半。问多少天这个绳子会小于5米？不考虑小数
         */
        int day = 0;
        for (int s = 3000; s >= 5; s /= 2) {
            day++;
        }
        System.out.println(day);


        int k = 0, l = 5;
        tp:
        for (; ; ) {
            k++;
            for (; ; ) {
                if (k > l--)//先运算再-1
                    break tp;
            }
        }
        System.out.println("k = " + k + ", l = " + l);   //k=1,l=-1;

        System.out.println("*****************");

        /*
    输出从1到100之间所有不能被3整除的数;并输出这些整数的和
     */
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 != 0) {
                sum += i;
            }
        }
        System.out.println(sum);

       


    }
}
