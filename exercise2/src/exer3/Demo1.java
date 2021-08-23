package exer3;

import org.junit.Test;

public class Demo1 {
    @Test
    public void test1(){
        String s = "people";
        String t = "people";
        String c[ ] = {"p","e","o","p","l","e"};
        System.out.println(s==t);
        System.out.println(s.equals(t));

        long round = Math.round(11.5);
        System.out.println(round);//12

        System.out.println(Math.round(-11.5));


    }
}
