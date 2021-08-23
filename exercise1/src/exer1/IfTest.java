package exer1;

import java.util.Scanner;

public class IfTest {
    /*
    假设你想开发一个玩彩票的游戏，程序随机地产生一个两位数的彩票，提示用户输入一个两位数，然后按照下面的规则判定用户是否能赢。

1)如果用户输入的数匹配彩票的实际顺序，奖金10 000美元。
2)如果用户输入的所有数字匹配彩票的所有数字，但顺序不一致，奖金 3 000美元。
3)如果用户输入的一个数字仅满足顺序情况下匹配彩票的一个数字，奖金1 000美元。
4)如果用户输入的一个数字仅满足非顺序情况下匹配彩票的一个数字，奖金500美元。
5)如果用户输入的数字没有匹配任何一个数字，则彩票作废。
     */

    public static void main(String[] args) {


        System.out.println("请输入两位数:");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int numshi = num / 10;
        int numge = num % 10;

        int num1 = (int) (Math.random() * 90 + 10);
        int num1shi = num1 / 10;
        int num1ge = num1 % 10;

        System.out.println("系统随机产生的数是：" + num1);
        if (num == num1) {
            System.out.println("奖金10000$");
        } else if (numshi == num1ge && numge == num1ge) {
            System.out.println("奖金3000$");
        } else if (numshi == num1shi || numge == num1ge) {
            System.out.println("奖金1000$");
        } else if (numshi == num1ge || numge == num1ge) {
            System.out.println("奖金500$");
        } else {
            System.out.println("Nothing");
        }


        /*
        提供三个1-6的随机数，作为掷骰子得到的点数。
        如果各个点数相同，则为豹子。
        如果三个骰子点数和，小于或等于9，则为“小”。
        如果三个骰子点数和，大于9，则为“大”。
        用户随机选择：押大、押小或者押豹子。通过判断，输出客户是否押正确。
         */
        int number1 = (int) (Math.random() * 6 + 1);
        int number2 = (int) (Math.random() * 6 + 1);
        int number3 = (int) (Math.random() * 6 + 1);
        String result;

        if (number1 == number3 && number1 == number2) {
            result = "豹子";
        } else if (number1 + number2 + number3 <= 9) {
            result = "小";
        } else {
            result = "大";
        }

        Scanner scan1 = new Scanner(System.in);
        System.out.println("请输入你的猜测(大/小/豹子)");
        String guess = scan1.next();
        if (guess.equals(result)) {
            System.out.println("猜对了");
        } else {
            System.out.println("猜错了");
        }

    }
}



