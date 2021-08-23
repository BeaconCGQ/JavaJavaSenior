package com.atguigu.java;
import org.junit.Test;

public class IDEADebug {

    @Test
    public void test1(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//4
        System.out.println(sb);//"null"
        StringBuffer sb1 = new StringBuffer(str);//NullPointerException
        System.out.println(sb1);
    }
}
