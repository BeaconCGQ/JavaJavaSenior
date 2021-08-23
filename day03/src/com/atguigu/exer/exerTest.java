package com.atguigu.exer;

public class exerTest {

    public static void main(String[] args) {


        exerTest test = new exerTest();
        String trim = test.trim("  a h sds   ");
        System.out.println("空"+ trim + "格");


    }
    //去除字符串两端空格
    public String trim(String str){

        int start = 0  ;
        int end = str.length() - 1;
        while(start <= end && str.charAt(start) == ' '){
            start++;
        }

        while (start <= end && str.charAt(end) == ' '){
            end--;
        }

        return str.substring(start,end+1);






    }


}
