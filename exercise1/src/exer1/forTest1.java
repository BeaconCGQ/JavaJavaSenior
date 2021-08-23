package exer1;

import org.junit.Test;

import java.util.Scanner;

public class forTest1 {
    public static void main(String[] args) {

        //求两个数的最大公约数和最小公倍数
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入两个正整数：");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        int max = num1 > num2 ? num1 : num1;
        int min = num1 < num2 ? num1 : num2;

        for (int i = min; i > 0; i--) {
            if(num1 % i == 0 & num2 % i == 0){
                System.out.println("最大公约数：" + i);
                break;
            }
        }
        for (int i = max;; i++) {
            if(i % num1 == 0 && i % num2 == 0){
                System.out.println("最小公倍数：" + i);
                break;
            }
        }

        //求调和级数中从第多少项开始值大于10
        //调和级数的第n项形式为：1+1/2+1/3+…+1/n
        double sum = 0;
        int count = 0;
        for (int i = 1;; i++) {
            sum += 1.0 / i;
            count++;
            if(sum > 10){
                System.out.println(count);
                break;
            }
        }

    }

    @Test
    public void test1(){



    }

}
