package exer1;

import org.junit.Test;

public class ArraysTest {

    @Test
    public void test1() {
        /*
        创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
         */

        int[] arr1 = new int[6];
        for (int i = 0; i < arr1.length; i++) {// [0,1) [0,30) [1,31)
            arr1[i] = (int) (Math.random() * 30) + 1;

            for (int j = 0; j < i; j++) {
                if (arr1[i] == arr1[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
    }

    @Test
    public void test2() {
       /*
           创建一个char类型的36个元素的数组，前26个元素放置'A'-'Z',   后10个元素放置'0'-'9'。
           使用for循环访问所有元素并打印出来。
           提示：char类型数据运算 'A'+1 -> 'B'，'0'+1 -> '1'
       */
        char[] arr = new char[36];
        for (int i = 0; i < arr.length; i++) {

            if (i < 26) {
                arr[i] = (char) ('A' + i);
            } else {
                arr[i] = (char) ('0' + i - 26);
            }
        }

        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
        }

        System.out.println("*******************");

        //斐波那契数列
        int fib[] = new int[20];
        for (int i = 0; i < fib.length; i++) {
            if (i == 0) {
                fib[i] = 1;
            } else if (i == 1) {
                fib[1] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        for (int i = 0; i < fib.length; i++) {
//            System.out.print(fib[i] + " ");
        }
        System.out.println("*********************");

        //求一个3*3矩阵对角线元素之和
        int[][] rectangle = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = 0;
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++) {
                if (i == j) {
                    sum += rectangle[i][j];
                } else if (i + j == 2 && i != j) {
                    sum += rectangle[i][j];
                }

            }
        }

//        System.out.println(sum);



    }

}
