package exer11;


import org.junit.jupiter.api.Test;

import java.util.Date;

public class Demo3 {
    @Test
    public void test1(){

        int arr[] = {1,2,3};
        try {
            System.out.println(arr[3]);
        }finally{
            System.out.println("123");
        }

    }
    @Test
    public void test2(){

        Object obj = new Date();
        String s = (String)obj;
    }
}
